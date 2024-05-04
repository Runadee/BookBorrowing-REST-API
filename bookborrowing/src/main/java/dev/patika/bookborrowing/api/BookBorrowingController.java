package dev.patika.bookborrowing.api;

import dev.patika.bookborrowing.business.abstracts.IBookBorrowingService;
import dev.patika.bookborrowing.business.abstracts.IBookService;
import dev.patika.bookborrowing.core.config.modelMapper.IModelMapperService;
import dev.patika.bookborrowing.core.result.Result;
import dev.patika.bookborrowing.core.result.ResultData;
import dev.patika.bookborrowing.core.utilies.ResultHelper;
import dev.patika.bookborrowing.dto.request.bookBorrowing.BookBorrowingSaveRequest;
import dev.patika.bookborrowing.dto.request.bookBorrowing.BookBorrowingUpdateRequest;
import dev.patika.bookborrowing.dto.response.CursorResponse;
import dev.patika.bookborrowing.dto.response.bookBorrowing.BookBorrowingResponse;
import dev.patika.bookborrowing.entities.Book;
import dev.patika.bookborrowing.entities.BookBorrowing;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/book-borrowings")
public class BookBorrowingController {


    private final IBookBorrowingService bookBorrowingService;
    private final IModelMapperService modelMapper;
    private final IBookService bookService;


    public BookBorrowingController(IBookBorrowingService bookBorrowingService, IModelMapperService modelMapper, IBookService bookService) {
        this.bookBorrowingService = bookBorrowingService;
        this.modelMapper = modelMapper;
        this.bookService = bookService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookBorrowingResponse> save(@Valid @RequestBody BookBorrowingSaveRequest bookBorrowingSaveRequest) {

        BookBorrowing saveBookBorrowing =this.modelMapper.forRequest().map(bookBorrowingSaveRequest, BookBorrowing.class);

        Book book = this.bookService.get(bookBorrowingSaveRequest.getBookId());
        saveBookBorrowing.setBook(book);

        this.bookBorrowingService.save(saveBookBorrowing);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveBookBorrowing, BookBorrowingResponse.class));
    }


    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookBorrowingResponse> update(@Valid @RequestBody BookBorrowingUpdateRequest bookBorrowingUpdateRequest) {
        BookBorrowing updateBookBorrowing =this.modelMapper.forRequest().map(bookBorrowingUpdateRequest, BookBorrowing.class);
        this.bookBorrowingService.update(updateBookBorrowing);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateBookBorrowing, BookBorrowingResponse.class));
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") Long id) {
        this.bookBorrowingService.delete(id);
        return ResultHelper.ok();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookBorrowingResponse> get(@PathVariable("id") Long id) {
        BookBorrowing bookBorrowing = this.bookBorrowingService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(bookBorrowing, BookBorrowingResponse.class));
    }


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<BookBorrowingResponse>> cursor(
            @RequestParam(name = "page",required = false,defaultValue = "0") int page,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize) {

        Page<BookBorrowing> bookBorrowingPage = this.bookBorrowingService.cursor(page,pageSize);
        Page<BookBorrowingResponse> bookBorrowingResponsePage = bookBorrowingPage
                .map(bookBorrowing -> this.modelMapper.forResponse().map(bookBorrowing, BookBorrowingResponse.class));

        return ResultHelper.cursor(bookBorrowingResponsePage);
    }


}
