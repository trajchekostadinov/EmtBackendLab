package com.example.emtbackendlab.service.domain.impl;

import com.example.emtbackendlab.model.domain.Author;
import org.springframework.stereotype.Service;
import com.example.emtbackendlab.repository.AuthorRepository;
import com.example.emtbackendlab.service.domain.AuthorService;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Optional<Author> update(Long id, Author author) {
        return authorRepository
                .findById(id)
                .map((existingAuthor) -> {
                    existingAuthor.setName(author.getName());
                    existingAuthor.setSurname(author.getSurname());
                    existingAuthor.setCountry(author.getCountry());
                    return authorRepository.save(existingAuthor);
                });
    }

    @Override
    public Optional<Author> deleteById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        author.ifPresent(authorRepository::delete);
        return author;
    }
}
