package com.example.emtbackendlab.listeners;

import com.example.emtbackendlab.events.BookRentedEvent;
import com.example.emtbackendlab.model.domain.ActivityLog;
import com.example.emtbackendlab.repository.ActivityLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.time.LocalDateTime;

@Component
@Slf4j
public class BookRentedEventListener {

    private final ActivityLogRepository activityLogRepository;

    public BookRentedEventListener(ActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Async
    public void onBookRented(BookRentedEvent event){
        log.info("[ASYNC - thread: {}] Book '{}' rented by '{}'.",
                Thread.currentThread().getName(),
                event.book().getName(),
                event.rentedBy());

        ActivityLog logEntry = new ActivityLog(
                event.book().getName(),
                LocalDateTime.now(),
                "RENTED"
        );

        activityLogRepository.save(logEntry);

        log.info("Activity log saved for book '{}'", event.book().getName());
    }
}
