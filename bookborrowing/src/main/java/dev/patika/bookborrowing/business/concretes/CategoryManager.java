package dev.patika.bookborrowing.business.concretes;

import dev.patika.bookborrowing.business.abstracts.ICategoryService;
import dev.patika.bookborrowing.core.exception.NotFoundException;
import dev.patika.bookborrowing.core.utilies.Msg;
import dev.patika.bookborrowing.dao.BookRepo;
import dev.patika.bookborrowing.dao.CategoryRepo;
import dev.patika.bookborrowing.dto.response.category.CategoryResultResponse;
import dev.patika.bookborrowing.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryManager implements ICategoryService {

    private final CategoryRepo categoryRepo;
    private final BookRepo bookRepo;

    public CategoryManager(CategoryRepo categoryRepo, BookRepo bookRepo) {
        this.categoryRepo = categoryRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category get(Long id) {
        return this.categoryRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Category> cursor(int page, int pageSize) {

        Pageable pageable = PageRequest.of(page, pageSize);
        return this.categoryRepo.findAll(pageable);
    }

    @Override
    public Category update(Category category) {

        this.get(category.getId());
        return this.categoryRepo.save(category);
    }

    @Override
    public CategoryResultResponse delete(Long id) {

        if (!bookRepo.existsByCategoryList_Id(id)) {

            Category category = this.get(id);
            this.categoryRepo.delete(category);
            return CategoryResultResponse.builder().result(Msg.OK).build();
        }
        return CategoryResultResponse.builder().result(Msg.CATEGORY_EXIST).build();
    }
}
