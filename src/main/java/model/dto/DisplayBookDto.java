package model.dto;

import model.domain.Book;

import java.util.List;

public record DisplayBookDto(
        Long id,
        String name,
        Book.Category category,
        DisplayAuthorDto author,
        Book.State state,
        Integer availableCopies
) {
    public static DisplayBookDto from(Book book) {
        return new DisplayBookDto(
                book.getId(),
                book.getName(),
                book.getCategory(),
                DisplayAuthorDto.from(book.getAuthor()),
                book.getState(),
                book.getAvailableCopies()
        );
    }

    public static List<DisplayBookDto> from(List<Book> books) {
        return books.stream().map(DisplayBookDto::from).toList();
    }
}