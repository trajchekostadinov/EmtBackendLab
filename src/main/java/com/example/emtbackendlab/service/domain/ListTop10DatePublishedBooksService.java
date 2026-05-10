package com.example.emtbackendlab.service.domain;

import com.example.emtbackendlab.model.domain.Book;
import com.example.emtbackendlab.model.dto.DisplayBookDto;

import java.util.List;

public interface ListTop10DatePublishedBooksService {

    List<DisplayBookDto> findLatestBooks();
}
