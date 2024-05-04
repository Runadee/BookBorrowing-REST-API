package dev.patika.bookborrowing.business.abstracts;

import dev.patika.bookborrowing.entities.Publisher;
import org.springframework.data.domain.Page;

public interface IPublisherService {

    Publisher save(Publisher publisher);
    Publisher get(Long id);
    Page<Publisher> cursor(int page, int pageSize);
    Publisher update(Publisher publisher);
    boolean delete(Long id);
}
