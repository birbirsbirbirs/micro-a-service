package co.pitam.aservice.controller;


import co.pitam.aservice.model.Hero;
import co.pitam.aservice.service.PtmAsynService;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HeroController {

    @Value("${b-service.url}")
    private String bServiceUrl;

    private final RestTemplate restTemplate;
    private final WebClient webClient;
    private final Tracer tracer;
    private final PtmAsynService ptmAsynService;


    @GetMapping
    public Hero getHero() {
        String randomString = UUID.randomUUID().toString();
        log.info("updating power value: {}", randomString);
//        tracer.createBaggageInScope("power", "power-" + randomString);

        ptmAsynService.runLog();

        Hero hero = restTemplate.getForObject(bServiceUrl, Hero.class);
        log.info("Hero from b-service: {}", hero);
        return hero;
    }

    @GetMapping("/webclient")
    public Hero getHeroWebClient() {
        String randomString = UUID.randomUUID().toString();
        log.info("updating power value webclient: {}", randomString);
        tracer.createBaggageInScope("power", "power-" + randomString);

        ptmAsynService.runLog();

        Hero hero = webClient.get().uri(bServiceUrl)
                .retrieve()
                .bodyToMono(Hero.class)
                .block();

        log.info("Hero from webclient, b-service: {}", hero);
        return hero;
    }
}
