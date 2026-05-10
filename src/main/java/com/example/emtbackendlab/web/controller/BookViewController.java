package com.example.emtbackendlab.web.controller;

import com.example.emtbackendlab.model.dto.DisplayBookViewDto;
import com.example.emtbackendlab.service.application.BookViewApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books-view")
public class BookViewController {

    private final BookViewApplicationService bookViewApplicationService;

    public BookViewController(BookViewApplicationService bookViewApplicationService) {
        this.bookViewApplicationService = bookViewApplicationService;
    }

    @GetMapping()
    public ResponseEntity<List<DisplayBookViewDto>> findAll(){
        return ResponseEntity.ok(bookViewApplicationService.findAll());
    }
}
