package com.example.emtbackendlab.service.domain.impl;

import com.example.emtbackendlab.model.domain.Book;
import com.example.emtbackendlab.model.enumeration.BookState;
import com.example.emtbackendlab.model.exception.BookNotAvailableException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.emtbackendlab.repository.BookRepository;
import com.example.emtbackendlab.service.domain.BookService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

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
        Optional<Book> book = bookRepository.findById(id);
        book.ifPresent(bookRepository::delete);
        return book;
    }

    /**
     * Обележува книга како изнајмена: намалува availableCopies за 1.
     * Фрла BookNotAvailableException ако нема достапни копии или ако книгата е во лоша состојба.
     */
    @Override
    @Transactional
    public Optional<Book> rent(Long id) {
        return bookRepository.findById(id).map(book -> {
            if (book.getAvailableCopies() <= 0 || book.getState() == BookState.BAD) {
                throw new BookNotAvailableException(id);
            }
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            return bookRepository.save(book);
        });
    }

    @Transactional
    public Optional<Book> returnBook(Long id) {
        return bookRepository.findById(id).map(book -> {
            book.setAvailableCopies(book.getAvailableCopies() + 1);
            return bookRepository.save(book);
        });
    }


    public int availableCopies(Long bookId) {
        return bookRepository.findById(bookId)
                .map(Book::getAvailableCopies)
                .orElse(0);
    }
}
