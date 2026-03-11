package service.application;

import model.dto.CreateAuthorDto;
import model.dto.DisplayAuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorApplicationService {
    Optional<DisplayAuthorDto> findById(Long id);

    List<DisplayAuthorDto> findAll();

    DisplayAuthorDto create(CreateAuthorDto createAuthorDto);

    Optional<DisplayAuthorDto> update(Long id, CreateAuthorDto createAuthorDto);

    Optional<DisplayAuthorDto> deleteById(Long id);
}
