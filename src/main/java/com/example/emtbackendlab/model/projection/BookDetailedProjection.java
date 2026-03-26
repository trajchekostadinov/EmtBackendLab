package com.example.emtbackendlab.model.projection;

import com.example.emtbackendlab.model.domain.Country;
import com.example.emtbackendlab.model.enumeration.BookCategory;
import com.example.emtbackendlab.model.enumeration.BookState;

public interface BookDetailedProjection {
    Long getId();
    String getName();
    BookCategory getCategory();
    BookState getState();
    Integer getAvailableCopies();

    String getAuthorName();
    String getAuthorSurname();
    Country getAuthorCountry();
}
