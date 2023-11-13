package com.chensoul.springevent.synchronous;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomSpringEventListener implements ApplicationListener<CustomSpringEvent> {

    @Override
    public void onApplicationEvent(final CustomSpringEvent event) {
		log.info("Received spring custom event - " + event.getMessage());
    }

}
