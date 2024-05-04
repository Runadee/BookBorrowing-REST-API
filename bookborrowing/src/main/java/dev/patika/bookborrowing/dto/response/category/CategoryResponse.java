package dev.patika.bookborrowing.dto.response.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CategoryResponse {
    private Long id;
    private String name;
    private String description;
}
