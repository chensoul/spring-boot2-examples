package com.chensoul.springevent.synchronous;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GenericSpringEventListener implements ApplicationListener<GenericSpringAppEvent<String>> {

    // for testing
    private boolean hitEventHandler = false;

    @Override
    public void onApplicationEvent(@NonNull final GenericSpringAppEvent<String> event) {
        log.info("Received spring generic event - " + event.getWhat());
        hitEventHandler = true;
    }

    boolean isHitEventHandler() {
        return hitEventHandler;
    }
}
