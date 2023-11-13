package com.chensoul.springevent.synchronous;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.springframework.util.Assert.isTrue;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = { SynchronousSpringEventConfig.class }, loader = AnnotationConfigContextLoader.class)
public class ContextRefreshedListenerIntegrationTest {

    @Autowired
    private ContextRefreshedListener listener;

    @Test
    public void testContextRefreshedListener() {
        isTrue(listener.isHitContextRefreshedHandler(), "Refresh should be called once");
    }
}
