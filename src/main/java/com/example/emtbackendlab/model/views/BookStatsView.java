package com.example.emtbackendlab.model.views;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Entity
@Getter
@Immutable // ova znaci samo read-only. Nemoze insert/update/delete da se pravi
@Table(name = "books_stats_view")
public class BookStatsView {

    @Id
    private String category;

    private Long totalBooks;

    private Integer totalAvailableCopies;

    private Long notGoodConditionBooks;
}
