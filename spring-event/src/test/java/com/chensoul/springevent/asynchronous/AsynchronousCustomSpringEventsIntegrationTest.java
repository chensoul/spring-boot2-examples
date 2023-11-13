package com.chensoul.springevent.asynchronous;

import com.chensoul.springevent.synchronous.CustomSpringEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@Slf4j
@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {AsynchronousSpringEventConfig.class}, loader = AnnotationConfigContextLoader.class)
public class AsynchronousCustomSpringEventsIntegrationTest {

	@Autowired
	private CustomSpringEventPublisher publisher;

	@Test
	public void testCustomSpringEvents() throws InterruptedException {
		publisher.publishCustomEvent("Hello world!!");
		log.info("Done publishing asynchronous custom event. ");
	}
}
