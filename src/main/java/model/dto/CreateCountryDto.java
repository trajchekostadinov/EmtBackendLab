package model.dto;

import jakarta.validation.constraints.NotBlank;
import model.domain.Author;
import model.domain.Country;

public record CreateCountryDto(
        @NotBlank String name,
        @NotBlank String continent
) {

    public Country toCountry() {
        Country country = new Country();
        country.setName(name);
        country.setContinent(continent);
        return country;
    }
}