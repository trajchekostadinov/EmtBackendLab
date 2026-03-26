package com.example.emtbackendlab.service.domain.impl;

import com.example.emtbackendlab.model.views.BookView;
import com.example.emtbackendlab.repository.BookViewRepository;
import com.example.emtbackendlab.service.domain.BookViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookViewServiceImpl implements BookViewService {

    private final BookViewRepository bookViewRepository;

    public BookViewServiceImpl(BookViewRepository bookViewRepository) {
        this.bookViewRepository = bookViewRepository;
    }

    @Override
    public List<BookView> findAll() {
        return bookViewRepository.findAll();
    }
}
