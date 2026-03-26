package com.example.emtbackendlab.web.controller;

import com.example.emtbackendlab.model.domain.Book;
import com.example.emtbackendlab.model.dto.CreateBookDto;
import com.example.emtbackendlab.model.dto.DisplayBookDto;
import com.example.emtbackendlab.model.dto.DisplayBookListDto;
import com.example.emtbackendlab.model.enumeration.BookCategory;
import com.example.emtbackendlab.model.enumeration.BookState;
import com.example.emtbackendlab.model.projection.BookDetailedProjection;
import com.example.emtbackendlab.model.projection.BookShortProjection;
import com.example.emtbackendlab.repository.BookRepository;
import com.example.emtbackendlab.service.domain.BookService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.emtbackendlab.service.application.BookApplicationService;

import jakarta.validation.Valid;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookApplicationService bookApplicationService;
    private final BookService bookService;
    private final BookRepository bookRepository;



    public BookController(BookApplicationService bookApplicationService, BookService bookService, BookRepository bookRepository) {
        this.bookApplicationService = bookApplicationService;
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayBookDto> findById(@PathVariable Long id){
        return bookApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DisplayBookDto>> findAll(){
        return ResponseEntity.ok(bookApplicationService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayBookDto> create(@RequestBody @Valid CreateBookDto createBookDto){
        return ResponseEntity.ok(bookApplicationService.create(createBookDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayBookDto> update(
            @PathVariable Long id,
            @RequestBody @Valid CreateBookDto createBookDto
    ) {
        return bookApplicationService
                .update(id, createBookDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //lab2 1.Pagination
    @GetMapping("/pagination")
    public ResponseEntity<Page<DisplayBookListDto>> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ){
        return ResponseEntity.ok(bookService.findAll(page,size,sortBy));
    }

    @GetMapping("/list-books")
    public Page<DisplayBookListDto> listBooks(
            @RequestParam(required = false) BookCategory category,
            @RequestParam(required = false) BookState state,
            @RequestParam(required = false) String authorName,
            @RequestParam(required = false) Boolean available,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        return bookService.listBooks(category, state, authorName, available, page, size, sortBy);
    }

    @GetMapping("/entity-graph")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }


    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayBookDto> deleteById(@PathVariable Long id){
        return bookApplicationService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/rent")
    public ResponseEntity<DisplayBookDto> rent (@PathVariable Long id){
        return bookApplicationService
                .rent(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/short")
    public List<BookShortProjection> getShortBooks() {
        return bookRepository.findAllShortBy();
    }

    @GetMapping("/details")
    public List<BookDetailedProjection> getDetailedBooks() {
        return bookRepository.findAllDetailedBy();
    }
}