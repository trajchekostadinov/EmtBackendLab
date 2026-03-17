package com.example.emtbackendlab.service.domain;

import com.example.emtbackendlab.model.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Optional<Author> findById(Long id);

    List<Author> findAll();

    Author create(Author author);

    Optional<Author> update(Long id, Author author);

    Optional<Author> deleteById(Long id);

}
