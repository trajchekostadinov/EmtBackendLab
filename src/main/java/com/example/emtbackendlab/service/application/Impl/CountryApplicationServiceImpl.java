package com.example.emtbackendlab.service.application.Impl;

import com.example.emtbackendlab.model.dto.CreateCountryDto;
import com.example.emtbackendlab.model.dto.DisplayCountryDetailsDto;
import com.example.emtbackendlab.model.dto.DisplayCountryDto;
import com.example.emtbackendlab.service.application.CountryApplicationService;
import com.example.emtbackendlab.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryApplicationServiceImpl implements CountryApplicationService {

    private final CountryService countryService;

    public CountryApplicationServiceImpl(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public Optional<DisplayCountryDto> findById(Long id) {
        return countryService
                .findById(id)
                .map(DisplayCountryDto::from);
    }

    @Override
    public List<DisplayCountryDto> findAll() {
        return DisplayCountryDto.from(countryService.findAll());
    }

    @Override
    public DisplayCountryDto create(CreateCountryDto createCountryDto) {
        return DisplayCountryDto.from(countryService.create(createCountryDto.toCountry(null)));
    }

    @Override
    public Optional<DisplayCountryDto> update(Long id, CreateCountryDto createCountryDto) {
        return countryService
                .update(id, createCountryDto.toCountry(null))
                .map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> deleteById(Long id) {
        return countryService
                .deleteById(id)
                .map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDetailsDto> findWithDetailsById(Long id) {
        return countryService
                .findById(id)
                .map(DisplayCountryDetailsDto::from);
    }
}
