package com.example.emtbackendlab.service.application.Impl;

import com.example.emtbackendlab.model.dto.DisplayBookViewDto;
import com.example.emtbackendlab.repository.BookViewRepository;
import com.example.emtbackendlab.service.application.BookViewApplicationService;
import com.example.emtbackendlab.service.domain.BookViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookViewApplicationServiceImpl implements BookViewApplicationService {
    private final BookViewService bookViewService;

    public BookViewApplicationServiceImpl(BookViewRepository bookViewRepository, BookViewService bookViewService) {
        this.bookViewService = bookViewService;
    }

    public List<DisplayBookViewDto> findAll() {
        return DisplayBookViewDto.from(bookViewService.findAll());
    }
}
