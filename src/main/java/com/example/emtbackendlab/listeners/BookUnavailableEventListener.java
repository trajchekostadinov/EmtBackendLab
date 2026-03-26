package com.example.emtbackendlab.listeners;

import com.example.emtbackendlab.events.BookUnavailableEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class BookUnavailableEventListener {
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Async
    public void onBookUnavailable(BookUnavailableEvent event) {
        log.info("Book '{}' is now unavailable!", event.book().getName());
    }
}
