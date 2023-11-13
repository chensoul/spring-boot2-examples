package com.chensoul.scheduling;

import com.chensoul.scheduling.dynamic.DynamicSchedulingConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@SpringBootTest
@ContextConfiguration(classes = {
  DynamicSchedulingConfig.class}, loader = AnnotationConfigContextLoader.class)
public class DynamicSchedulingIntegrationTest {

    @Test
    public void testTickServiceTick() throws InterruptedException {
        Thread.sleep(6000);
    }
}
