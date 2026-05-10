package com.example.emtbackendlab.model.dto;

import com.example.emtbackendlab.model.domain.Book;
import com.example.emtbackendlab.model.enumeration.BookCategory;
import com.example.emtbackendlab.model.enumeration.BookState;

import java.util.List;

public record DisplayBookDetailsDto(
        Long id,
        String name,
        BookCategory category,
        DisplayAuthorDto author,
        BookState state,
        Integer availableCopies
) {
    public static DisplayBookDetailsDto from(Book book) {
        return new DisplayBookDetailsDto(
                book.getId(),
                book.getName(),
                book.getCategory(),
                DisplayAuthorDto.from(book.getAuthor()),
                book.getState(),
                book.getAvailableCopies()
        );
    }
}