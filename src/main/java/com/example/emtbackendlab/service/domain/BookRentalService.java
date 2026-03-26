package com.example.emtbackendlab.service.domain;

public interface BookRentalService {
    void rentBook(Long bookId, String rentedBy);
}