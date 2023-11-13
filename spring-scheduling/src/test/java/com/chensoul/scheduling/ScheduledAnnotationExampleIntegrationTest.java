package com.chensoul.scheduling;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@SpringBootTest
@ContextConfiguration(classes = { SpringSchedulingConfig.class }, loader = AnnotationConfigContextLoader.class)
public class ScheduledAnnotationExampleIntegrationTest {

    @Test
    public void testScheduledAnnotation() throws InterruptedException {
        Thread.sleep(5000);
    }
}
