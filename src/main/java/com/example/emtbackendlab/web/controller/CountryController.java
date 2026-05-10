package com.example.emtbackendlab.web.controller;

import com.example.emtbackendlab.model.dto.CreateCountryDto;
import com.example.emtbackendlab.model.dto.DisplayCountryDetailsDto;
import com.example.emtbackendlab.model.dto.DisplayCountryDto;
import com.example.emtbackendlab.service.application.CountryApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryApplicationService countryApplicationService;

    public CountryController(CountryApplicationService countryApplicationService) {
        this.countryApplicationService = countryApplicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayCountryDto> findById(@PathVariable Long id){
        return countryApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<DisplayCountryDetailsDto> findWithDetailsById(@PathVariable Long id) {
        return countryApplicationService
                .findWithDetailsById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DisplayCountryDto>> findAll(){
        return ResponseEntity.ok(countryApplicationService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayCountryDto> create(@RequestBody @Valid CreateCountryDto createCountryDto){
        return ResponseEntity.ok(countryApplicationService.create(createCountryDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayCountryDto> update(
            @PathVariable Long id,
            @RequestBody @Valid CreateCountryDto createCountryDto
    ) {
        return countryApplicationService
                .update(id, createCountryDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayCountryDto> deleteById(@PathVariable Long id){
        return countryApplicationService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
