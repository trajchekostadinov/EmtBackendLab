package service.application;

import model.dto.CreateAuthorDto;
import model.dto.CreateCountryDto;
import model.dto.DisplayAuthorDto;
import model.dto.DisplayCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    Optional<DisplayCountryDto> findById(Long id);

    List<DisplayCountryDto> findAll();

    DisplayCountryDto create(CreateCountryDto createCountryDto);

    Optional<DisplayCountryDto> update(Long id, CreateCountryDto createCountryDto);

    Optional<DisplayCountryDto> deleteById(Long id);
}
