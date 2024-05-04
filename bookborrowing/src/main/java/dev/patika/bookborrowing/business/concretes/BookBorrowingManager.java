package dev.patika.bookborrowing.business.concretes;

import dev.patika.bookborrowing.business.abstracts.IBookBorrowingService;
import dev.patika.bookborrowing.core.exception.NotFoundException;
import dev.patika.bookborrowing.core.utilies.Msg;
import dev.patika.bookborrowing.dao.BookBorrowingRepo;
import dev.patika.bookborrowing.dao.BookRepo;
import dev.patika.bookborrowing.entities.Book;
import dev.patika.bookborrowing.entities.BookBorrowing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookBorrowingManager implements IBookBorrowingService {

    private final BookBorrowingRepo bookBorrowingRepo;
    private final BookRepo bookRepo;

    public BookBorrowingManager(BookBorrowingRepo bookBorrowingRepo, BookRepo bookRepo) {
        this.bookBorrowingRepo = bookBorrowingRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public BookBorrowing save(BookBorrowing bookBorrowing) {

       Book book = bookRepo.findById(bookBorrowing.getBook().getId())
               .orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
         if (book.getStock() > 0){
             book.setStock(book.getStock() - 1);
             bookRepo.save(book);
             bookBorrowing.setBook(book);
             return this.bookBorrowingRepo.save(bookBorrowing);
         }
         else {
             throw new NotFoundException(Msg.STOCK_NOT_ENOUGH);
         }
    }

    @Override
    public BookBorrowing get(Long id) {
        return this.bookBorrowingRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<BookBorrowing> cursor(int page, int pageSize) {

        Pageable pageable = PageRequest.of(page, pageSize);
        return this.bookBorrowingRepo.findAll(pageable);
    }

    @Override
    public BookBorrowing update(BookBorrowing bookBorrowing) {
        this.get(bookBorrowing.getId());
        return this.bookBorrowingRepo.save(bookBorrowing);
    }

    @Override
    public boolean delete(Long id) {
        BookBorrowing bookBorrowing = this.get(id);
        this.bookBorrowingRepo.delete(bookBorrowing);
        return true;
    }
}
