package co.pitam.aservice.ptmSNS;

import co.pitam.aservice.model.Hero;
import co.pitam.aservice.service.PtmAsynService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/sns")
public class PtmSNSController {
    private final PtmSNSService ptmSNSService;
    private final PtmAsynService ptmAsynService;
    @GetMapping
    public void publishHero() {
        Faker faker=new Faker();
        Hero hero = Hero.builder().name(faker.name().fullName())
                .power(faker.job().title())
                .build();
        ptmAsynService.runLog();
        log.info("sns publish hero: {}",hero);
        ptmSNSService.sendOrder(hero);
    }
}
