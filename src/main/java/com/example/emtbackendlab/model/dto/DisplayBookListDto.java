package com.example.emtbackendlab.model.dto;
import com.example.emtbackendlab.model.domain.Book;
import com.example.emtbackendlab.model.enumeration.BookCategory;
import com.example.emtbackendlab.model.enumeration.BookState;


// lab2 - 1. za pagination
public record DisplayBookListDto(
        Long id,
        String name,
        BookCategory category,
        BookState state,
        Integer availableCopies,
        String authorFullName
) {
    public static DisplayBookListDto from(Book book) {
        return new DisplayBookListDto(
                book.getId(),
                book.getName(),
                book.getCategory(),
                book.getState(),
                book.getAvailableCopies(),
                book.getAuthor().getName() + " " + book.getAuthor().getSurname()
        );
    }
}
