package co.pitam.aservice.service;


import co.pitam.aservice.model.Hero;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PublishHero {
    private final StreamBridge streamBridge;

    private final Tracer tracer;

    private final ObservationRegistry observationRegistry;


    public void sendOrder(Hero hero) {
        String randomString = UUID.randomUUID().toString();
        log.info("updating power producer binder: {}", randomString);
        tracer.createBaggageInScope("power", "power-" + randomString);
        Observation.createNotStarted("stream.producer", observationRegistry).observe(() -> {
            log.info("<ACCEPTANCE_TEST> <TRACE:{}> Hello from producer", this.tracer.currentSpan().context().traceId());
            this.streamBridge.send("output-out-0", hero);
        });
        log.info("Event sent: " + hero);
    }

}
