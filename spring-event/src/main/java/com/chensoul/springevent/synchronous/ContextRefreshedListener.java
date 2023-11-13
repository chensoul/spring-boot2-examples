package com.chensoul.springevent.synchronous;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    // for tests
    private boolean hitContextRefreshedHandler = false;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent cse) {
		log.info("Handling context re-freshed event. ");
        hitContextRefreshedHandler = true;
    }

    boolean isHitContextRefreshedHandler() {
        return hitContextRefreshedHandler;
    }
}
