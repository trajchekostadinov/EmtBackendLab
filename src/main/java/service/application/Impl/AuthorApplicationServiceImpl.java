package service.application.Impl;

import model.domain.Author;
import model.domain.Country;
import model.dto.CreateAuthorDto;
import model.dto.DisplayAuthorDto;
import org.springframework.stereotype.Service;
import service.application.AuthorApplicationService;
import service.domain.AuthorService;
import service.domain.CountryService;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorApplicationServiceImpl implements AuthorApplicationService {
    private final AuthorService authorService;
    private final CountryService countryService;

    public AuthorApplicationServiceImpl(AuthorService authorService, CountryService countryService) {
        this.authorService = authorService;
        this.countryService = countryService;
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
        Country country = countryService.findById(createAuthorDto.countryId())
                .orElseThrow(() -> new RuntimeException("Country not found"));

        Author author = createAuthorDto.toAuthor(country);

        Author savedAuthor = authorService.create(author);

        return DisplayAuthorDto.from(savedAuthor);
    }
    @Override
    public Optional<DisplayAuthorDto> update(Long id, CreateAuthorDto createAuthorDto) {
        return authorService.findById(id).map(existingAuthor -> {
            Country country = countryService.findById(createAuthorDto.countryId())
                    .orElseThrow(() -> new RuntimeException("Country not found"));

            existingAuthor.setName(createAuthorDto.name());
            existingAuthor.setSurname(createAuthorDto.surname());
            existingAuthor.setCountry(country);

            Author updatedAuthor = authorService.update(id, existingAuthor).orElseThrow();

            return DisplayAuthorDto.from(updatedAuthor);
        });
    }

    @Override
    public Optional<DisplayAuthorDto> deleteById(Long id) {
        return authorService.findById(id).map(author -> {
            authorService.deleteById(id);
            return DisplayAuthorDto.from(author);
        });
    }
}
