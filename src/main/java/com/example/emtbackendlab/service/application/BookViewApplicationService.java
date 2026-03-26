package com.example.emtbackendlab.service.application;

import com.example.emtbackendlab.model.dto.DisplayBookViewDto;

import java.util.List;

// lab2 - 4. za database view
public interface BookViewApplicationService {
    List<DisplayBookViewDto> findAll();
}
