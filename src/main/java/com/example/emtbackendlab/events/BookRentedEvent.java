package com.example.emtbackendlab.events;


import com.example.emtbackendlab.model.domain.Book;

// lab2 - 7. za event handling pri iznajmuvanje kniga
public record BookRentedEvent(Book book, String rentedBy) {
}