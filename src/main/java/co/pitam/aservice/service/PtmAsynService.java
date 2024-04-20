package co.pitam.aservice.service;


import io.micrometer.tracing.CurrentTraceContext;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
@Async
public class PtmAsynService {
    private final Tracer tracer;

    @SneakyThrows
    public void runLog() {
        CurrentTraceContext currentTraceContext = tracer.currentTraceContext();
        Thread.sleep(300);
        log.info("logging from the async service!!!");
    }

}
