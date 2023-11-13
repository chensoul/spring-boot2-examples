package com.chensoul.springevent.synchronous;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.springframework.util.Assert.isTrue;

@Slf4j
@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {SynchronousSpringEventConfig.class}, loader = AnnotationConfigContextLoader.class)
public class SynchronousCustomSpringEventsIntegrationTest {

    @Autowired
    private CustomSpringEventPublisher publisher;
    @Autowired
    private AnnotationDrivenEventListener listener;

    @Test
    public void testCustomSpringEvents() {
        isTrue(!listener.isHitCustomEventHandler(), "The value should be false");
        publisher.publishCustomEvent("Hello world!!");
        log.info("Done publishing synchronous custom event. ");
        isTrue(listener.isHitCustomEventHandler(), "Now the value should be changed to true");
    }

    @Test
    public void testGenericSpringEvent() {
        isTrue(!listener.isHitSuccessfulEventHandler(), "The initial value should be false");
        publisher.publishGenericEvent("Hello world!!!", true);
        isTrue(listener.isHitSuccessfulEventHandler(), "Now the value should be changed to true");
    }

    @Test
    public void testGenericSpringEventNotProcessed() {
        isTrue(!listener.isHitSuccessfulEventHandler(), "The initial value should be false");
        publisher.publishGenericEvent("Hello world!!!", false);
        isTrue(!listener.isHitSuccessfulEventHandler(), "The value should still be false");
    }

    @Test
    public void testContextStartedEvent() {
        isTrue(listener.isHitContextStartedHandler(), "Start should be called once");
    }
}
