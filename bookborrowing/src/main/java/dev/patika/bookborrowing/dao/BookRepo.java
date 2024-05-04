package dev.patika.bookborrowing.dao;

import dev.patika.bookborrowing.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    boolean existsByCategoryList_Id(Long categoryId);
}
