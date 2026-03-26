package com.example.emtbackendlab.model.dto;

import com.example.emtbackendlab.model.views.BookView;
import java.util.List;

// lab2 - 4. za database view
public record DisplayBookViewDto(
        Long id,
        String name,
        String category,
        String state,
        Integer availableCopies,
        String authorFullName,
        String countryName
) {
    public static DisplayBookViewDto from(BookView bookView){
        return new DisplayBookViewDto(
                bookView.getId(),
                bookView.getName(),
                bookView.getCategory(),
                bookView.getState(),
                bookView.getAvailableCopies(),
                bookView.getAuthorFullName(),
                bookView.getCountryName()
        );
    }

    public static List<DisplayBookViewDto> from (List<BookView> bookViews){
        return bookViews
                .stream()
                .map(DisplayBookViewDto::from)
                .toList();
    }
}

