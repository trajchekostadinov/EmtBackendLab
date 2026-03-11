package model.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import model.domain.Author;
import model.domain.Book;

public record CreateBookDto(
        @NotBlank(message = "Book name is required.")
        String name,

        @NotNull(message = "Category is required.")
        Book.Category category,

        @NotNull(message = "Author ID is required.")
        Long authorId,

        @NotNull(message = "State is required.")
        Book.State state,

        @Min(value = 0, message = "Available copies must be 0 or greater.")
        Integer availableCopies
) {

        public Book toBook(Author author) {
                Book book = new Book();
                book.setName(name);
                book.setCategory(category);
                book.setAuthor(author);
                book.setState(state);
                book.setAvailableCopies(availableCopies);
                return book;
        }

}