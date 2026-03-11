package model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import model.domain.Author;
import model.domain.Country;

public record CreateAuthorDto(
        @NotBlank String name,
        @NotBlank String surname,
        @NotNull Long countryId
) {
    // Прифати Country како аргумент
    public Author toAuthor(Country country) {
        Author author = new Author();
        author.setName(this.name);
        author.setSurname(this.surname);
        author.setCountry(country);
        return author;
    }

}