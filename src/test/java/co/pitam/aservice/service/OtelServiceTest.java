package co.pitam.aservice.service;

import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
/*
https://docs.micrometer.io/tracing/reference/api.html
 */
@SpringBootTest
class OtelServiceTest {

    @Autowired
    private Tracer tracer;

    @Test
    void getTracer() {
        Span newSpan = tracer.nextSpan().name("calcuateTax");

        try(Tracer.SpanInScope ws=this.tracer.withSpan(newSpan)){
            newSpan.tag("taxValue","taxValue");
            newSpan.event("taxCalculator");
        }finally {
            newSpan.end();
        }
    }


//    @Test
//    void testSpanInNewThread(){
//        Span spanFromThreadX = this.tracer.nextSpan().name("calculateTax");
//        try (Tracer.SpanInScope ws = this.tracer.withSpan(spanFromThreadX.start())) {
//            executorService.submit(() -> {
//                // Pass the span from thread X
//                Span continuedSpan = spanFromThreadX;
//                // ...
//                // You can tag a span
//                continuedSpan.tag("taxValue", taxValue);
//                // ...
//                // You can log an event on a span
//                continuedSpan.event("taxCalculated");
//            }).get();
//        }
//        finally {
//            spanFromThreadX.end();
//        }
//    }
}