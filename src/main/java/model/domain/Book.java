package model.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Book {

    public enum Category {
        NOVEL,
        THRILER,
        HISTORY,
        FANTASY,
        BIOGRAPHY,
        CLASSICS,
        DRAMA
    }

    public enum State {
        GOOD,
        BAD
    }

    public Book(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    private LocalDateTime createdAt;

    private LocalDateTime   updatedAt;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Author author;

    @Enumerated(EnumType.STRING)
    private State state;

    private Integer availableCopies;
}
