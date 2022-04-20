package sk.stuba.fei.uim.oop.assignment3.controller;

import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.service.api.BookService;
import sk.stuba.fei.uim.oop.assignment3.wrapper.attributes.BookAmount;
import sk.stuba.fei.uim.oop.assignment3.wrapper.attributes.BookLendCount;
import sk.stuba.fei.uim.oop.assignment3.wrapper.request.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.wrapper.response.BookResponse;
import sk.stuba.fei.uim.oop.assignment3.wrapper.updateRequest.BookUpdateRequest;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest request) throws NotFoundException {
        return new ResponseEntity<>(new BookResponse(bookService.addBook(request)),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable("id") Long id,
                                                   @RequestBody BookUpdateRequest updateRequest) throws NotFoundException {
        return new ResponseEntity<>(new BookResponse(bookService.updateBook(id, updateRequest)),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) throws NotFoundException {
        bookService.deleteBook(id);
    }

    @GetMapping
    public List<BookResponse> getAllBooks() {
        return bookService.getAllBooks()
                .stream()
                .map(BookResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}/amount")
    public BookAmount getBookAmount(@PathVariable("id") Long id) throws NotFoundException {
        return new BookAmount(bookService.getBookAmount(id));
    }

    @GetMapping("/{id}/lend")
    public BookLendCount getBookLendCount(@PathVariable("id") Long id) throws NotFoundException {
        return new BookLendCount(bookService.getBookLendCount(id));
    }
}