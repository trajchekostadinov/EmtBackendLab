package com.example.emtbackendlab.service.domain.impl;

import com.example.emtbackendlab.events.BookRentedEvent;
import com.example.emtbackendlab.events.BookUnavailableEvent;
import com.example.emtbackendlab.model.domain.Book;
import com.example.emtbackendlab.model.exception.BookNotAvailableException;
import com.example.emtbackendlab.model.exception.BookNotFoundException;
import com.example.emtbackendlab.repository.BookRepository;
import com.example.emtbackendlab.service.domain.BookRentalService;
import org.springframework.stereotype.Service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookRentalServiceImpl implements BookRentalService {

    private final BookRepository bookRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public BookRentalServiceImpl(BookRepository bookRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.bookRepository = bookRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    @Transactional
    public void rentBook(Long bookId, String rentedBy) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));

        if (book.getAvailableCopies() <= 0) {
            throw new BookNotAvailableException(bookId);
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);

        applicationEventPublisher.publishEvent(new BookRentedEvent(book, rentedBy));

        if (book.getAvailableCopies() == 0){
            applicationEventPublisher.publishEvent(new BookUnavailableEvent(book, rentedBy));
        }
    }
}
