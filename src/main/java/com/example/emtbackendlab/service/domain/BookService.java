package com.example.emtbackendlab.service.domain;

import com.example.emtbackendlab.model.domain.Book;
import com.example.emtbackendlab.model.dto.DisplayBookListDto;
import com.example.emtbackendlab.model.enumeration.BookCategory;
import com.example.emtbackendlab.model.enumeration.BookState;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> findById(Long id);

    List<Book> findAll();

    Book create(Book book);

    Optional<Book> update(Long id, Book book);

    Optional<Book> deleteById(Long id);

    Optional<Book> rent(Long id);

    Page<DisplayBookListDto> findAll(int page, int size, String sortBy);

    Page<DisplayBookListDto> listBooks(
            BookCategory category,
            BookState state,
            String authorName,
            Boolean available,
            int page,
            int size,
            String sortBy
    );

}
