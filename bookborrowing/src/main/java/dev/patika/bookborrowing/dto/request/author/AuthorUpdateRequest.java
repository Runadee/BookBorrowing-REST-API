package dev.patika.bookborrowing.dto.request.author;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorUpdateRequest {
    @Positive(message = "Id değeri pozitif tam sayı olmalıdır.")
    private Long id;

    @NotNull(message = "Yazar adı boş olamaz.")
    private String name;
    private LocalDate birthDate;
    private String country;
}
