package com.example.emtbackendlab.service.application;

import com.example.emtbackendlab.model.dto.DisplayBookViewDto;

import java.util.List;

public interface BookViewApplicationService {
    List<DisplayBookViewDto> findAll();
}
