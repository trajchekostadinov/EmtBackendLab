package com.example.emtbackendlab.model.domain;

import com.example.emtbackendlab.model.enumeration.BookCategory;
import com.example.emtbackendlab.model.enumeration.BookState;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "books")

@NamedEntityGraph(
        name = "book-entity-graph",
        attributeNodes = {
                @NamedAttributeNode(value = "author", subgraph = "author-subgraph"),
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "author-subgraph",
                        attributeNodes = {
                                @NamedAttributeNode("country")
                        }
                )
        }
)
public class Book extends BaseAuditableEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookCategory category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookState state;

    @Column(nullable = false)
    private Integer availableCopies;

    @Column(name = "date_published")
    private LocalDateTime datePublished;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Book(String name, BookCategory category, BookState state, Integer availableCopies, Author author,LocalDateTime datePublished) {
        this.name = name;
        this.category = category;
        this.state = state;
        this.availableCopies = availableCopies;
        this.author = author;
        this.datePublished = datePublished;
    }
    public Book(String name, BookCategory category, BookState state, Integer availableCopies, Author author) {
        this.name = name;
        this.category = category;
        this.state = state;
        this.availableCopies = availableCopies;
        this.author = author;
    }


}