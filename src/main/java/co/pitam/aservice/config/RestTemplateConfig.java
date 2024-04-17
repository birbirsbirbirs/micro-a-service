package co.pitam.aservice.config;

import brave.Tracing;
import brave.http.HttpTracing;
import brave.spring.web.TracingClientHttpRequestInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    public HttpTracing create(Tracing tracing) {
        return HttpTracing
                .newBuilder(tracing)
                .build();
    }
    @Bean
    public RestTemplate restTemplate(HttpTracing httpTracing) {
        return new RestTemplateBuilder()
                .interceptors(TracingClientHttpRequestInterceptor.create(httpTracing))
                .build();
    }
}
