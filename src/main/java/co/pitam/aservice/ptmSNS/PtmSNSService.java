package co.pitam.aservice.ptmSNS;

import co.pitam.aservice.model.Hero;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PtmSNSService {
    private final Tracer tracer;

    private final ObservationRegistry observationRegistry;
    private final StreamBridge streamBridge;


    public void sendOrder(Hero hero) {
        Observation.createNotStarted("stream.producer", observationRegistry).observe(() -> {
            this.streamBridge.send("ptmsns-out-0", hero);
        });
    }
}
