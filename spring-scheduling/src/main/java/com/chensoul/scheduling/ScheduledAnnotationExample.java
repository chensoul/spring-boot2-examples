package com.chensoul.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScheduledAnnotationExample {

    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        log.info("Fixed delay task - " + System.currentTimeMillis() / 1000);
    }

    @Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}")
    public void scheduleFixedDelayTaskUsingExpression() {
        log.info("Fixed delay task - " + System.currentTimeMillis() / 1000);
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 2000)
    public void scheduleFixedDelayWithInitialDelayTask() {
        log.info("Fixed delay task with one second initial delay - " + System.currentTimeMillis() / 1000);
    }

    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
        log.info("Fixed rate task - " + System.currentTimeMillis() / 1000);
    }

    @Scheduled(fixedRateString = "${fixedRate.in.milliseconds}")
    public void scheduleFixedRateTaskUsingExpression() {
        log.info("Fixed rate task - " + System.currentTimeMillis() / 1000);
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void scheduleFixedRateWithInitialDelayTask() {
        long now = System.currentTimeMillis() / 1000;
        log.info("Fixed rate task with one second initial delay - " + now);
    }

    /**
     * Scheduled task is executed at 10:15 AM on the 15th day of every month
     */
    @Scheduled(cron = "0 15 10 15 * ?")
    public void scheduleTaskUsingCronExpression() {
        long now = System.currentTimeMillis() / 1000;
        log.info("schedule tasks using cron jobs - " + now);
    }

    @Scheduled(cron = "${cron.expression}")
    public void scheduleTaskUsingExternalizedCronExpression() {
        log.info("schedule tasks using externalized cron expressions - " + System.currentTimeMillis() / 1000);
    }

}
