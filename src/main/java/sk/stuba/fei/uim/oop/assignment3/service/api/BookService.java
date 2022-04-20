package sk.stuba.fei.uim.oop.assignment3.service.api;

import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.model.Book;
import sk.stuba.fei.uim.oop.assignment3.wrapper.request.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.wrapper.updateRequest.BookUpdateRequest;

import java.util.List;

public interface BookService {

    Book addBook(BookRequest request);
    Book updateBook(Long id, BookUpdateRequest updateRequest) throws NotFoundException;
    void deleteBook(Long id) throws NotFoundException;
    List<Book> getAllBooks();
    Book getBookById(Long id) throws NotFoundException;
    Integer getBookAmount(Long id) throws NotFoundException;
    Integer getBookLendCount(Long id) throws NotFoundException;
}
