package com.example.emtbackendlab.model.domain;

import com.example.emtbackendlab.model.enumeration.BookCategory;
import com.example.emtbackendlab.model.enumeration.BookState;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "books")

// lab2 - 3. za entity graph(koga zemas book zemi go i avtor i country vo edno query da nema n+1 query problem)
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

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Book(String name, BookCategory category, BookState state, Integer availableCopies, Author author) {
        this.name = name;
        this.category = category;
        this.state = state;
        this.availableCopies = availableCopies;
        this.author = author;
    }
}