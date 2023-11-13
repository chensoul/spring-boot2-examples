package com.chensoul.springevent.synchronous;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.springframework.util.Assert.isTrue;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = { SynchronousSpringEventConfig.class }, loader = AnnotationConfigContextLoader.class)
public class GenericAppEventListenerIntegrationTest {

    @Autowired
    private CustomSpringEventPublisher publisher;
    @Autowired
    private GenericSpringEventListener listener;

    @Test
    public void testGenericSpringEvent() {
        isTrue(!listener.isHitEventHandler(), "The initial value should be false");
        publisher.publishGenericAppEvent("Hello world!!!");
        isTrue(listener.isHitEventHandler(), "Now the value should be changed to true");
    }

}
