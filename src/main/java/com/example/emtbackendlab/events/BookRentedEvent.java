package com.example.emtbackendlab.events;


import com.example.emtbackendlab.model.domain.Book;

public record BookRentedEvent(Book book, String rentedBy) {
}