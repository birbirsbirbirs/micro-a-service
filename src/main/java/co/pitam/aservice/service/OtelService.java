package co.pitam.aservice.service;

import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OtelService {
    private final Tracer tracer;

    public Tracer getTracer(){
        return tracer;
    }
}
