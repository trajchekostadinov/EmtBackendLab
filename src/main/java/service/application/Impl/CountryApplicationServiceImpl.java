package service.application.Impl;

import model.domain.Country;
import model.dto.CreateCountryDto;
import model.dto.DisplayCountryDto;
import org.springframework.stereotype.Service;
import service.application.CountryApplicationService;
import service.domain.CountryService;

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
        Country country = createCountryDto.toCountry();
        Country savedCountry = countryService.create(country);
        return DisplayCountryDto.from(savedCountry);
    }

    @Override
    public Optional<DisplayCountryDto> update(Long id, CreateCountryDto createCountryDto) {
        return countryService.findById(id).map(existingCountry -> {
            existingCountry.setName(createCountryDto.name());
            existingCountry.setContinent(createCountryDto.continent());

            Country updatedCountry = countryService.update(id, existingCountry)
                    .orElseThrow();

            return DisplayCountryDto.from(updatedCountry);
        });
    }


    @Override
    public Optional<DisplayCountryDto> deleteById(Long id) {
        return countryService.findById(id).map(country -> {
            countryService.deleteById(id);
            return DisplayCountryDto.from(country);
        });
    }
}
