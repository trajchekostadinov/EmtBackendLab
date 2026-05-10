package com.example.emtbackendlab.events;

import com.example.emtbackendlab.model.domain.Book;

public record BookUnavailableEvent(Book book, String rentedBy) {
}
