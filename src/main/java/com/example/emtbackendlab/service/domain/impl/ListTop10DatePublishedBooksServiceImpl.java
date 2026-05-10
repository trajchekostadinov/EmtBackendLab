package com.example.emtbackendlab.service.domain.impl;

import com.example.emtbackendlab.model.domain.Book;
import com.example.emtbackendlab.model.dto.DisplayBookDto;
import com.example.emtbackendlab.repository.BookRepository;
import com.example.emtbackendlab.repository.DatePublishedRepository;
import com.example.emtbackendlab.service.domain.ListTop10DatePublishedBooksService;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ListTop10DatePublishedBooksServiceImpl implements ListTop10DatePublishedBooksService {

    private final DatePublishedRepository datePublishedRepository;

    public ListTop10DatePublishedBooksServiceImpl(DatePublishedRepository datePublishedRepository) {
        this.datePublishedRepository = datePublishedRepository;
    }

    @Override
    public List<DisplayBookDto> findLatestBooks() {
        return datePublishedRepository.findTop10ByDatePublishedBefore(LocalDateTime.now());
    }
}

