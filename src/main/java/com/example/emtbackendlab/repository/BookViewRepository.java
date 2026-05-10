package com.example.emtbackendlab.repository;

import com.example.emtbackendlab.model.views.BookView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookViewRepository extends JpaRepository<BookView, Long> {
}
