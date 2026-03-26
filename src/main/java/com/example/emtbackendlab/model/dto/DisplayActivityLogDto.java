package com.example.emtbackendlab.model.dto;

import com.example.emtbackendlab.model.domain.ActivityLog;

import java.time.LocalDateTime;

public record DisplayActivityLogDto(
        String bookName,
        LocalDateTime eventTime,
        String eventType
) {
    public static DisplayActivityLogDto from(ActivityLog log) {
        return new DisplayActivityLogDto(
                log.getBookName(),
                log.getEventTime(),
                log.getEventType()
        );
    }
}
