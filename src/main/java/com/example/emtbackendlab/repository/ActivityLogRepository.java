package com.example.emtbackendlab.repository;

import com.example.emtbackendlab.model.domain.ActivityLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


// lab2 - 9. evidencija na aktivnosti
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
    Page<ActivityLog> findAll(Pageable pageable);
}
