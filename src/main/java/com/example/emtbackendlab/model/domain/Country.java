package com.example.emtbackendlab.model.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "countries")
public class Country extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String continent;

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}