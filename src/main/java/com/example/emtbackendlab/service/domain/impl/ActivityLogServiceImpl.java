package com.example.emtbackendlab.service.domain.impl;

import com.example.emtbackendlab.model.dto.DisplayActivityLogDto;
import com.example.emtbackendlab.repository.ActivityLogRepository;
import com.example.emtbackendlab.service.domain.ActivityLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {
    private final ActivityLogRepository activityLogRepository;

    public ActivityLogServiceImpl(ActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    @Override
    public Page<DisplayActivityLogDto> getAllActivityLogs(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return activityLogRepository.findAll(pageable).map(DisplayActivityLogDto::from);
    }
}
