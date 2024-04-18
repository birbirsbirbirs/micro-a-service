package co.pitam.aservice.service;

import io.micrometer.tracing.Tracer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class OtelServiceTest {

    @Autowired
    private OtelService otelService;

    @Test
    void getTracer() {
        Tracer tracer = otelService.getTracer();
        Assert.notNull(tracer,"trace mustn't be null");
    }
}