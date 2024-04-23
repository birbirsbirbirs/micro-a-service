package co.pitam.aservice.ptmInteceptors;

import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.GlobalChannelInterceptor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.messaging.support.MessageHeaderAccessor;

@RequiredArgsConstructor
@Slf4j
@Configuration
@GlobalChannelInterceptor(patterns = {"*out-*"})
public class PitamOutStreamInterceptor implements ChannelInterceptor {
    private final Tracer tracer;
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {

        String traceId = tracer.currentSpan().context().traceId();
//
        MessageHeaders headers = message.getHeaders();

        Message<?> newMessage = MessageBuilder.fromMessage(message).setHeader("traceId", traceId).build();


        log.info("output stream !!");


        MessageHeaderAccessor mutableAccessor = MessageHeaderAccessor.getMutableAccessor(message);
        return ChannelInterceptor.super.preSend(newMessage, channel);
    }
}
