package com.chensoul.scheduling.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TickService {

    private long delay = 0;

    public long getDelay() {
        this.delay += 1000;
        log.info("delaying " + this.delay + " milliseconds...");
        return this.delay;
    }

    public void tick() {
        final long now = System.currentTimeMillis() / 1000;
        System.out
                .println("schedule tasks with dynamic delay - " + now);
    }

}
