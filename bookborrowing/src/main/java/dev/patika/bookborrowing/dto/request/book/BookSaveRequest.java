package dev.patika.bookborrowing.dto.request.book;

import dev.patika.bookborrowing.entities.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveRequest {
    @NotNull
    private String name;
    private int publicationYear;
    private int stock;
    private Long publisherId;
    private Long authorId;
    private List<Category> categoryList;
}
