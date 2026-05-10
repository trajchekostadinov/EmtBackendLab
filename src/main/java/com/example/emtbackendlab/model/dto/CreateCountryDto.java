package com.example.emtbackendlab.model.dto;


import com.example.emtbackendlab.model.domain.Country;
import jakarta.validation.constraints.NotBlank;

public record CreateCountryDto (
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Continent is required")
        String continent
) {
    public Country toCountry (Country country){
        return new Country(name, continent);
    }
}
