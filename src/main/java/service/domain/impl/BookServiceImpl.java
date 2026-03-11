package service.domain.impl;

import model.domain.Book;
import org.springframework.stereotype.Service;
import repository.BookRepository;
import service.domain.BookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> update(Long id, Book book) {
        return bookRepository.findById(id).map(existingBook -> {
            existingBook.setName(book.getName());
            existingBook.setCategory(book.getCategory());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setState(book.getState());
            existingBook.setAvailableCopies(book.getAvailableCopies());
            return bookRepository.save(existingBook);
        });
    }

    @Override
    public Optional<Book> deleteById(Long id) {
        return bookRepository.findById(id).map(book -> {
            bookRepository.delete(book);
            return book;
        });
    }
}
