package com.example.emtbackendlab.web.controller;

import com.example.emtbackendlab.model.domain.Book;
import com.example.emtbackendlab.model.dto.DisplayBookDto;
import com.example.emtbackendlab.service.domain.ListTop10DatePublishedBooksService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/books")
public class DatePublishedController {

    private final ListTop10DatePublishedBooksService listTop10DatePublishedBooksService;

    public DatePublishedController(ListTop10DatePublishedBooksService listTop10DatePublishedBooksService) {
        this.listTop10DatePublishedBooksService = listTop10DatePublishedBooksService;
    }

    @GetMapping("/datePublished")
    public List<DisplayBookDto> getLatestBooks(){
        return listTop10DatePublishedBooksService.findLatestBooks();
    }
}
