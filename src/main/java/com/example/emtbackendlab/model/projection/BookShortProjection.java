package com.example.emtbackendlab.model.projection;


import com.example.emtbackendlab.model.enumeration.BookCategory;
import com.example.emtbackendlab.model.enumeration.BookState;

public interface BookShortProjection {
    Long getId();
    String getName();
    BookCategory getCategory();
    BookState getState();
    Integer getAvailableCopies();
}
