package web.controller;

import model.dto.CreateBookDto;
import model.dto.DisplayBookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.application.BookApplicationService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookApplicationService bookService;

    public BookController(BookApplicationService bookService) {
        this.bookService = bookService;
    }

    // 1️⃣ Добиј сите книги
    @GetMapping
    public List<DisplayBookDto> getAllBooks() {
        return bookService.findAll();
    }

    // 2️⃣ Добиј книга по ID
    @GetMapping("/{id}")
    public ResponseEntity<DisplayBookDto> getBookById(@PathVariable Long id) {
        return bookService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3️⃣ Додај нова книга
    @PostMapping
    public DisplayBookDto createBook(@RequestBody @Valid CreateBookDto createBookDto) {
        return bookService.create(createBookDto);
    }

    // 4️⃣ Ажурирај книга
    @PutMapping("/{id}")
    public ResponseEntity<DisplayBookDto> updateBook(@PathVariable Long id,
                                                     @RequestBody @Valid CreateBookDto createBookDto) {
        return bookService.update(id, createBookDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 5️⃣ Бриши книга (само ако е во лоша состојба)
    @DeleteMapping("/{id}")
    public ResponseEntity<DisplayBookDto> deleteBook(@PathVariable Long id) {
        return bookService.deleteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

//    @PatchMapping("/{id}/rent")
//    public ResponseEntity<DisplayBookDto> markAsRented(@PathVariable Long id) {
//        return bookService.findById(id)
//                .map(book -> {
//                    if (book.availableCopies() <= 0) {
//                        // Враќаме ResponseEntity со празно тело, но со тип DisplayBookDto
//                        return ResponseEntity.<DisplayBookDto>badRequest().build();
//                    }
//
//                    // Создавање нов DTO со намалено availableCopies
//                    CreateBookDto updatedDto = new CreateBookDto(
//                            book.name(),
//                            book.category(),
//                            book.author().id(),
//                            book.state(),
//                            book.availableCopies() - 1
//                    );
//
//                    DisplayBookDto updatedBook = bookService.update(id, updatedDto)
//                            .orElseThrow();
//
//                    return ResponseEntity.ok(updatedBook);
//                });
//    }
}