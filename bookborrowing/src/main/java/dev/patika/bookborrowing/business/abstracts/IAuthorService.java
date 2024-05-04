package dev.patika.bookborrowing.business.abstracts;

import dev.patika.bookborrowing.entities.Author;
import org.springframework.data.domain.Page;

public interface IAuthorService {
    Author save(Author author);
    Author get(Long id);
    Page<Author> cursor(int page, int pageSize);
    Author update(Author author);
    boolean delete(Long id);
}
