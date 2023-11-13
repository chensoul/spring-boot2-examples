package com.chensoul.springevent.synchronous;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class AnnotationDrivenEventListener {

    // for tests
    private boolean hitContextStartedHandler = false;
    private boolean hitSuccessfulEventHandler = false;
    private boolean hitCustomEventHandler = false;

    @EventListener
    public void handleContextStart(final ContextStartedEvent cse) {
        log.info("Handling context started event.");
        hitContextStartedHandler = true;
    }

    @EventListener(condition = "#event.success")
    public void handleSuccessful(final GenericSpringEvent<String> event) {
        log.info("Handling generic event (conditional): " + event.getWhat());
        hitSuccessfulEventHandler = true;
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handleCustom(final CustomSpringEvent event) {
        log.info("Handling event inside a transaction BEFORE COMMIT.");
        hitCustomEventHandler = true;
    }

    boolean isHitContextStartedHandler() {
        return hitContextStartedHandler;
    }

    boolean isHitSuccessfulEventHandler() {
        return hitSuccessfulEventHandler;
    }

    boolean isHitCustomEventHandler() {
        return hitCustomEventHandler;
    }
}
