package co.pitam.aservice.config;


import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import io.opentelemetry.context.Context;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class TracePropagationInterceptor implements ClientHttpRequestInterceptor {

    private final Tracer tracer;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        Context currentContext = Context.current();
        Span span = tracer.currentSpan();

        HttpHeaders headers = request.getHeaders();
//        headers.add("traceparent",);
//        headers.add("tracestate",);
        return execution.execute(request, body);
    }
}
