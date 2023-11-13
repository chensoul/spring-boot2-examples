package com.chensoul.scheduling;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchedulingWithXmlConfig {

    public void scheduleFixedDelayTask() {
        log.info("Fixed delay task - " + System.currentTimeMillis() / 1000);
    }

    public void scheduleFixedRateTask() {
        log.info("Fixed rate task - " + System.currentTimeMillis() / 1000);
    }

    public void scheduleTaskUsingCronExpression() {
        log.info("schedule tasks using cron expressions - " + System.currentTimeMillis() / 1000);
    }
}
