package dev.patika.bookborrowing.business.abstracts;

import dev.patika.bookborrowing.dto.response.category.CategoryResultResponse;
import dev.patika.bookborrowing.entities.Category;
import org.springframework.data.domain.Page;

public interface ICategoryService {

    Category save(Category category);

    Category get(Long id);

    Page<Category> cursor(int page, int pageSize);

    Category update(Category category);

    CategoryResultResponse delete(Long id);
}
