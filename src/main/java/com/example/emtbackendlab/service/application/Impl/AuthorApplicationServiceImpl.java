package com.example.emtbackendlab.service.application.Impl;

import com.example.emtbackendlab.model.domain.Author;
import com.example.emtbackendlab.model.domain.Country;
import com.example.emtbackendlab.model.dto.CreateAuthorDto;
import com.example.emtbackendlab.model.dto.DisplayAuthorDto;
import com.example.emtbackendlab.model.exception.CountryNotFoundException;
import com.example.emtbackendlab.repository.CountryRepository;
import org.springframework.stereotype.Service;
import com.example.emtbackendlab.service.application.AuthorApplicationService;
import com.example.emtbackendlab.service.domain.AuthorService;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorApplicationServiceImpl implements AuthorApplicationService {

    private final AuthorService authorService;
    private final CountryRepository countryRepository;

    public AuthorApplicationServiceImpl(AuthorService authorService, CountryRepository countryRepository) {
        this.authorService = authorService;
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<DisplayAuthorDto> findById(Long id) {
        return authorService
                .findById(id)
                .map(DisplayAuthorDto::from);
    }

    @Override
    public List<DisplayAuthorDto> findAll() {
        return DisplayAuthorDto.from(authorService.findAll());
    }

    @Override
    public DisplayAuthorDto create(CreateAuthorDto createAuthorDto) {
        Country country = countryRepository
                .findById(createAuthorDto.countryId())
                .orElseThrow(() -> new CountryNotFoundException(createAuthorDto.countryId()));

        return DisplayAuthorDto.from(authorService.create(createAuthorDto.toAuthor(country)));
    }

    @Override
    public Optional<DisplayAuthorDto> update(Long id, CreateAuthorDto createAuthorDto) {
        Country country = countryRepository
                .findById(createAuthorDto.countryId())
                .orElseThrow(() -> new CountryNotFoundException(createAuthorDto.countryId()));

        return authorService
                .update(id, createAuthorDto.toAuthor(country))
                .map(DisplayAuthorDto::from);
    }

    @Override
    public Optional<DisplayAuthorDto> deleteById(Long id) {
        return authorService
                .deleteById(id)
                .map(DisplayAuthorDto::from);
    }
}