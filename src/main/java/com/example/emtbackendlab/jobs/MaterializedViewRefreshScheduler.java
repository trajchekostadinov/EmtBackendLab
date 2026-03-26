package com.example.emtbackendlab.jobs;

import com.example.emtbackendlab.repository.BookStatsViewRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MaterializedViewRefreshScheduler {

    private final BookStatsViewRepository bookStatsViewRepository;

    public MaterializedViewRefreshScheduler(BookStatsViewRepository bookStatsViewRepository) {
        this.bookStatsViewRepository = bookStatsViewRepository;
    }

    @Scheduled(cron = "0 * * * * *") //ke se refreshira na ->
    @Transactional
    public void refreshBooksStatsView() {
        log.info("Refreshing BOOKS_STATS_MV...");

        bookStatsViewRepository.refresh();

        log.info("BOOKS_STATS_MV successfully refreshed.");
    }
}
