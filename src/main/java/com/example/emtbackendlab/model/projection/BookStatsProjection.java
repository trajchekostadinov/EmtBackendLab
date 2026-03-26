package com.example.emtbackendlab.model.projection;

public interface BookStatsProjection {
    String getCategory();
    Long getTotalBooks();
    Integer getTotalAvailableCopies();
    Long getNotGoodConditionBooks();
}