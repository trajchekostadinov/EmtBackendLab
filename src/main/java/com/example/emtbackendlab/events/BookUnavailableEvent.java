package com.example.emtbackendlab.events;

import com.example.emtbackendlab.model.domain.Book;

// lab2 - 8. za listener za nedostapni knigi
public record BookUnavailableEvent(Book book, String rentedBy) {
}
