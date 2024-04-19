package co.pitam.aservice.config;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PtmLoggingHandler implements ObservationHandler<Observation.Context> {
    @Override
    public boolean supportsContext(Observation.Context context) {
        return true;
    }

    @Override
    public void onStart(Observation.Context context) {
//        log.info("Starting context {} ", context);
    }

    @Override
    public void onError(Observation.Context context) {
//        log.info("Error for context {} ", context);
    }

    @Override
    public void onEvent(Observation.Event event, Observation.Context context) {
//        log.info("Event for context {} and event [ {} ]", context, event);
    }

    @Override
    public void onScopeOpened(Observation.Context context) {
//        log.info("Scope opened for context {} ", context);

    }

    @Override
    public void onScopeClosed(Observation.Context context) {
//        log.info("Scope closed for context {}", context);
    }

    @Override
    public void onStop(Observation.Context context) {
//        log.info("Stopping context {} ", context);
    }
}
