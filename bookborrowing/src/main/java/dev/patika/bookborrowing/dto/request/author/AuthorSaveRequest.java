package dev.patika.bookborrowing.dto.request.author;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorSaveRequest {
    @NotNull(message = "Yazar adı boş veya null olamaz")
    private String name;
    private LocalDate birthDate;
    private String country;
}
