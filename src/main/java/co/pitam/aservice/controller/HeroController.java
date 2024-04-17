package co.pitam.aservice.controller;


import co.pitam.aservice.model.Hero;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
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

    @GetMapping
    public Hero getHero(){
        Hero hero = restTemplate.getForObject(bServiceUrl, Hero.class);
        log.info("Hero from b-service: {}",hero);
//        MDC.put("email","email-1000");


        log.info("logging after!!");
        return hero;
    }
}
