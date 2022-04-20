package sk.stuba.fei.uim.oop.assignment3.service.impl;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.model.Book;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.repository.BookRepository;
import sk.stuba.fei.uim.oop.assignment3.service.api.AuthorService;
import sk.stuba.fei.uim.oop.assignment3.service.api.BookService;
import sk.stuba.fei.uim.oop.assignment3.wrapper.request.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.wrapper.updateRequest.BookUpdateRequest;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public Book addBook(BookRequest request) {
        return bookRepository.save(new Book(request));
    }

    @Override
    public Book updateBook(Long id, BookUpdateRequest updateRequest) throws NotFoundException {
        Book book = getBookById(id);
        if (updateRequest.getName() != null) {
            book.setName(updateRequest.getName());
        }
        if (updateRequest.getDescription() != null) {
            book.setDescription(updateRequest.getDescription());
        }
        if (updateRequest.getAuthorId() != null) {
            book.setAuthor(authorService.getAuthorById(id));
        }
        if (updateRequest.getPages() != null) {
            book.setPages(updateRequest.getPages());
        }
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) throws NotFoundException {
        Book book = getBookById(id);
        bookRepository.delete(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) throws NotFoundException {
        Book book = bookRepository.findBookById(id);
        if (book == null) {
            throw new NotFoundException();
        }
        return book;
    }

    @Override
    public Integer getBookAmount(Long id) throws NotFoundException {
        return getBookById(id).getAmount();
    }

    @Override
    public Integer getBookLendCount(Long id) throws NotFoundException {
        return getBookById(id).getLendCount();
    }
}
