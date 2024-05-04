package dev.patika.bookborrowing.dto.request.bookBorrowing;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingUpdateRequest {
    @Positive
    private Long id;

    @NotNull
    private String borrowerName;

    private LocalDate borrowingDate;
    private LocalDate returnDate;
}
