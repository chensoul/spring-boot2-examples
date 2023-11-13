package com.chensoul.springevent.synchronous;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomSpringEventPublisher {

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	public void publishCustomEvent(final String message) {
		log.info("Publishing custom event. ");
		final CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, message);
		applicationEventPublisher.publishEvent(customSpringEvent);
	}

	public void publishGenericEvent(final String message, boolean success) {
		log.info("Publishing generic event.");
		final GenericSpringEvent<String> genericSpringEvent = new GenericStringSpringEvent(message, success);
		applicationEventPublisher.publishEvent(genericSpringEvent);
	}

	public void publishGenericAppEvent(final String message) {
		log.info("Publishing generic event.");
		final GenericSpringAppEvent<String> genericSpringEvent = new GenericStringSpringAppEvent(this, message);
		applicationEventPublisher.publishEvent(genericSpringEvent);
	}

}
