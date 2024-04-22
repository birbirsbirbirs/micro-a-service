package co.pitam.aservice.ptmSNS;

import co.pitam.aservice.model.Hero;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

@Service
@Slf4j
@RequiredArgsConstructor
public class PtmSNSService {
    private final BlockingQueue<Hero> orderEvent = new LinkedBlockingQueue<>();

    @Bean
    public Supplier<Hero> ptmsns() {
        return () -> this.orderEvent.poll();
    }

    public void sendOrder(Hero hero) {
        this.orderEvent.offer(hero);
        log.info("Event sent: " + hero);
    }
}
