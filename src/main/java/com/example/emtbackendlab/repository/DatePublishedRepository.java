package com.example.emtbackendlab.repository;

import com.example.emtbackendlab.model.domain.Book;
import com.example.emtbackendlab.model.dto.DisplayBookDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DatePublishedRepository extends JpaRepository<Book,Long> {
    List<DisplayBookDto> findTop10ByDatePublishedBefore(LocalDateTime time);
}
