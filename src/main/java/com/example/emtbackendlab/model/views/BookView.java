package com.example.emtbackendlab.model.views;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

// lab2 - 4. za database view
@Entity
@Getter
@Immutable // ova znaci samo read-only. Nemoze insert/update/delete da se pravi
@Table(name = "books_view")
public class BookView {
    @Id
    private Long id;

    private String name;

    private String category;

    private String state;

    private Integer availableCopies;

    private String authorFullName;

    private String countryName;
}

