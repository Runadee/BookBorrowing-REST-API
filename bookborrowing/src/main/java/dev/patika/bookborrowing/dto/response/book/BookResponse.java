package dev.patika.bookborrowing.dto.response.book;

import dev.patika.bookborrowing.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    private Long id;
    private String name;
    private int publicationYear;
    private int stock;
    private Long publisherId;
    private Long authorId;
    private List<Category> categoryList;

}
