package dev.patika.bookborrowing.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "book_borrowings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_borrowing_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "book_borrower_name", length = 150, nullable = false)
    private String borrowerName;

    @Column(name = "book_borrower_email")
    private String borrowerEmail;

    @Column(name = "book_borrowing_date")
    private LocalDate borrowingDate;

    @Column(name = "book_return_date")
    private LocalDate returnDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrowing_book_id", referencedColumnName = "book_id")
    private Book book;
}
