package dev.patika.bookborrowing.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "authors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "author_id", columnDefinition = "serial")
    private Long id;

    @NotNull
    @Column(name = "author_name", length = 150)
    private String name;

    @Column(name = "author_birth_date")
    private LocalDate birthDate;

    @Column(name = "author_country")
    private String country;

    @OneToMany(mappedBy = "author")
    private List<Book> bookList;
}
