package com.example.emtbackendlab.web.controller;

import com.example.emtbackendlab.model.dto.DisplayActivityLogDto;
import com.example.emtbackendlab.service.domain.ActivityLogService;
import com.example.emtbackendlab.service.domain.BookRentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// lab2 - 7. za event handling pri iznajmuvanje kniga
@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookRentalController {

    private final BookRentalService bookRentalService;
    private final ActivityLogService activityLogService;

    @PostMapping("/{bookId}/rent")
    public ResponseEntity<String> rentBook(@PathVariable Long bookId, @RequestParam String userEmail) {
        // lab2 - 7. za event handling pri iznajmuvanje kniga
        try {
            bookRentalService.rentBook(bookId, userEmail);
            return ResponseEntity.ok("Book rented successfully for " + userEmail);
        }
        // lab2 - 8. za listener za nedostapni knigi
        catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

//     lab2 - 9. evidencija na aktivnosti
    @GetMapping("/activity-logs")
    public ResponseEntity<Page<DisplayActivityLogDto>> getAllActivities(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "bookName") String sortBy
    ) {
        return ResponseEntity.ok(activityLogService.getAllActivityLogs(page, size, sortBy));
    }

}
