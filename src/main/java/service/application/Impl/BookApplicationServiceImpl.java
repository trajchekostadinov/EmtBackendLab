package service.application.Impl;

import model.domain.Author;
import model.domain.Book;
import model.dto.CreateBookDto;
import model.dto.DisplayBookDto;
import org.springframework.stereotype.Service;
import service.application.BookApplicationService;
import service.domain.AuthorService;
import service.domain.BookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookApplicationServiceImpl implements BookApplicationService {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookApplicationServiceImpl(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public Optional<DisplayBookDto> findById(Long id) {
        return bookService
                .findById(id)
                .map(DisplayBookDto::from);
    }

    @Override
    public List<DisplayBookDto> findAll() {
        return DisplayBookDto.from(bookService.findAll());
    }

    @Override
    public DisplayBookDto create(CreateBookDto createBookDto) {
        Author author = authorService.findById(createBookDto.authorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Book book = createBookDto.toBook(author);

        Book savedBook = bookService.create(book);

        return DisplayBookDto.from(savedBook);
    }

    @Override
    public Optional<DisplayBookDto> update(Long id, CreateBookDto createBookDto) {
        return bookService.findById(id).map(existingBook -> {
            Author author = authorService.findById(createBookDto.authorId())
                    .orElseThrow(() -> new RuntimeException("Author not found"));

            existingBook.setName(createBookDto.name());
            existingBook.setCategory(createBookDto.category());
            existingBook.setAuthor(author);
            existingBook.setState(createBookDto.state());
            existingBook.setAvailableCopies(createBookDto.availableCopies());

            Book updatedBook = bookService.update(id, existingBook)
                    .orElseThrow();

            return DisplayBookDto.from(updatedBook);
        });
    }

    @Override
    public Optional<DisplayBookDto> deleteById(Long id) {
        return bookService.findById(id).map(book -> {
            bookService.deleteById(id);
            return DisplayBookDto.from(book);
        });
    }
}
