package co.pitam.aservice.ptmInteceptors;

import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.GlobalChannelInterceptor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;

@RequiredArgsConstructor
@Slf4j
@Configuration
@GlobalChannelInterceptor(patterns = {"*out-*"})
public class PitamOutStreamInterceptor implements ChannelInterceptor {
    private final Tracer tracer;
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {

//        String traceId = tracer.currentTraceContext().context().traceId();
//        Map<String, String> allBaggage = tracer.getAllBaggage();
//
//        message.getHeaders().put("traceId",traceId);
//        message.getHeaders().put("baggage",allBaggage.toString());


        MessageHeaderAccessor mutableAccessor = MessageHeaderAccessor.getMutableAccessor(message);
        return ChannelInterceptor.super.preSend(message, channel);
    }
}
