package com.example.emtbackendlab.model.dto;

import com.example.emtbackendlab.model.domain.Country;

public record DisplayCountryDetailsDto(
        Long id,
        String name,
        String continent
) {
    public static DisplayCountryDetailsDto from(Country country) {
        return new DisplayCountryDetailsDto(
                country.getId(),
                country.getName(),
                country.getContinent()
        );
    }
}
