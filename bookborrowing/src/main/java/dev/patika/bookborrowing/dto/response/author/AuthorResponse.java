package dev.patika.bookborrowing.dto.response.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthorResponse {
    private Long id;
    private String name;
    private String birthDate;
    private String country;
}
