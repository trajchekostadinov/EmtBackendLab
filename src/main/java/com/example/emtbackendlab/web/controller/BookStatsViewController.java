package com.example.emtbackendlab.web.controller;
import com.example.emtbackendlab.model.projection.BookStatsProjection;
import com.example.emtbackendlab.repository.BookStatsViewRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/book-stats")
public class BookStatsViewController {

    private final BookStatsViewRepository bookStatsViewRepository;

    public BookStatsViewController(BookStatsViewRepository bookStatsViewRepository) {
        this.bookStatsViewRepository = bookStatsViewRepository;
    }

    @GetMapping
    public List<BookStatsProjection> getStats() {
        return bookStatsViewRepository.findAllBy();
    }
}