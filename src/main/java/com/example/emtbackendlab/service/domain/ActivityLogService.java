package com.example.emtbackendlab.service.domain;

import com.example.emtbackendlab.model.dto.DisplayActivityLogDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

// lab2 - 9. evidencija na aktivnosti
public interface ActivityLogService {
    Page<DisplayActivityLogDto> getAllActivityLogs(int page, int size, String sortBy);
}
