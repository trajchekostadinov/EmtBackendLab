package service.application;

import model.dto.CreateBookDto;
import model.dto.DisplayBookDto;

import java.util.List;
import java.util.Optional;

public interface BookApplicationService {
    Optional<DisplayBookDto> findById(Long id);

    List<DisplayBookDto> findAll();

    DisplayBookDto create(CreateBookDto createBookDto);

    Optional<DisplayBookDto> update(Long id, CreateBookDto createBookDto);

    Optional<DisplayBookDto> deleteById(Long id);
}
