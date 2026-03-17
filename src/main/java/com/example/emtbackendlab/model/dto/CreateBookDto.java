package com.example.emtbackendlab.model.dto;
import com.example.emtbackendlab.model.domain.Author;
import com.example.emtbackendlab.model.domain.Book;
import com.example.emtbackendlab.model.enumeration.BookCategory;
import com.example.emtbackendlab.model.enumeration.BookState;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public record CreateBookDto(
        @NotBlank String name,
        @NotNull BookCategory category,
        @NotNull BookState state,
        @NotNull Integer availableCopies,
        @NotNull Long authorId
) {
    public Book toBook(Author author) {
        return new Book(name, category, state, availableCopies, author);
    }
}
