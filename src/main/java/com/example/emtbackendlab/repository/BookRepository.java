package com.example.emtbackendlab.repository;

import com.example.emtbackendlab.model.domain.Book;
import com.example.emtbackendlab.model.enumeration.BookCategory;
import com.example.emtbackendlab.model.enumeration.BookState;
import com.example.emtbackendlab.model.projection.BookDetailedProjection;
import com.example.emtbackendlab.model.projection.BookShortProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    // lab2 - 1. za pagination
    Page<Book> findAll(Pageable pageable); // metod za paginacija

    //metod za filtriranje spored ... navedenoto
    Page<Book> findByCategoryAndStateAndAuthorNameContainingAndAvailableCopiesGreaterThan(
            BookCategory category,
            BookState state,
            String authorName,
            Integer availableCopies,
            Pageable pageable
    );
    // lab2 - 3. za entity graph
    @EntityGraph(value = "book-entity-graph", type = EntityGraph.EntityGraphType.FETCH)
    List<Book> findAll();

    // lab2 - 2. za projections
    List<BookShortProjection> findAllShortBy();
    List<BookDetailedProjection> findAllDetailedBy();
}
