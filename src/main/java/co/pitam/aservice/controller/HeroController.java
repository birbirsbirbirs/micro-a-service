package co.pitam.aservice.controller;


import co.pitam.aservice.model.Hero;
import io.micrometer.observation.annotation.Observed;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HeroController {

    @Value("${b-service.url}")
    private String bServiceUrl;

    private final RestTemplate restTemplate;
    private final Tracer tracer;

    @Observed(
            name = "demoService"
    )
    @GetMapping
    public Hero getHero() {

        tracer.createBaggageInScope("power", "power-400");

        Hero hero = restTemplate.getForObject(bServiceUrl, Hero.class);
        log.info("Hero from b-service: {}", hero);
        return hero;
    }
}
