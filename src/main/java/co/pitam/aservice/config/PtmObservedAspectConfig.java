package co.pitam.aservice.config;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class PtmObservedAspectConfig {
    // To have the @Observed support we need to register this aspect
    @Bean
    ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
        observationRegistry.observationConfig().observationHandler(new PtmLoggingHandler());
        return new ObservedAspect(observationRegistry);
    }


}
