package com.example.emtbackendlab.repository;

import com.example.emtbackendlab.model.projection.BookStatsProjection;
import com.example.emtbackendlab.model.views.BookStatsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookStatsViewRepository extends JpaRepository<BookStatsView, String> {
    List<BookStatsProjection> findAllBy();
    @Modifying // kazuvame deka ke go menime zosto po default ne se refreshira avtomatski
    @Query(value = "refresh materialized view books_stats_view",nativeQuery = true)
    void refresh();
}
