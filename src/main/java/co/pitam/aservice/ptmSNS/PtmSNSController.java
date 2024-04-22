package co.pitam.aservice.ptmSNS;

import co.pitam.aservice.model.Hero;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/sns")
public class PtmSNSController {
    private final PtmSNSService ptmSNSService;
    @PostMapping
    public void publishHero(@RequestBody Hero hero) {
        ptmSNSService.sendOrder(hero);
    }
}
