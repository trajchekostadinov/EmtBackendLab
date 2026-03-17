package com.example.emtbackendlab.model.dto;

import com.example.emtbackendlab.model.domain.Book;
import com.example.emtbackendlab.model.enumeration.BookCategory;
import com.example.emtbackendlab.model.enumeration.BookState;

import java.util.List;

public record DisplayBookDto(
        Long id,
        String name,
        BookCategory category,
        Long authorId,
        BookState state,
        Integer availableCopies
) {

    public static DisplayBookDto from(Book book) {
        return new DisplayBookDto(
                book.getId(),
                book.getName(),
                book.getCategory(),
                book.getAuthor().getId(),
                book.getState(),
                book.getAvailableCopies()
        );
    }

    public static List<DisplayBookDto> from(List<Book> books) {
        return books.stream()
                .map(DisplayBookDto::from)
                .toList();
    }
}