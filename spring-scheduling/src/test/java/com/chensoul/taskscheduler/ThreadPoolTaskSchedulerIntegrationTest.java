package com.chensoul.taskscheduler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = { ThreadPoolTaskSchedulerConfig.class }, loader = AnnotationConfigContextLoader.class)
public class ThreadPoolTaskSchedulerIntegrationTest {

    @Test
    public void testThreadPoolTaskSchedulerAnnotation() throws InterruptedException {
        Thread.sleep(2550);
    }
}
