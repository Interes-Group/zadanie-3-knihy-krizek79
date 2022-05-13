package sk.stuba.fei.uim.oop.assignment3.book.service;

import sk.stuba.fei.uim.oop.assignment3.book.dto.BookAmount;
import sk.stuba.fei.uim.oop.assignment3.book.dto.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.dto.BookUpdateRequest;
import sk.stuba.fei.uim.oop.assignment3.book.model.Book;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

public interface BookService {

    Book addBook(BookRequest request) throws NotFoundException;
    Book updateBook(Long id, BookUpdateRequest updateRequest) throws NotFoundException;
    void deleteBook(Long id) throws NotFoundException;
    List<Book> getAllBooks();
    Book getBookById(Long id) throws NotFoundException;
    Integer addBookAmount(Long id, BookAmount bookAmount) throws NotFoundException;
    Integer getBookAmount(Long id) throws NotFoundException;
    Integer getBookLendCount(Long id) throws NotFoundException;
}
