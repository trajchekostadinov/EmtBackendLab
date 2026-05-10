package com.example.emtbackendlab.service.application;

import com.example.emtbackendlab.model.dto.CreateCountryDto;
import com.example.emtbackendlab.model.dto.DisplayCountryDetailsDto;
import com.example.emtbackendlab.model.dto.DisplayCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    Optional<DisplayCountryDto> findById(Long id);

    List<DisplayCountryDto> findAll();

    DisplayCountryDto create(CreateCountryDto createCountryDto);

    Optional<DisplayCountryDto> update(Long id, CreateCountryDto createCountryDto);

    Optional<DisplayCountryDto> deleteById(Long id);

    Optional<DisplayCountryDetailsDto> findWithDetailsById(Long id);
}
