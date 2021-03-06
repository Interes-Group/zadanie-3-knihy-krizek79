package sk.stuba.fei.uim.oop.assignment3.book.service;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.dto.BookAmount;
import sk.stuba.fei.uim.oop.assignment3.book.dto.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.dto.BookUpdateRequest;
import sk.stuba.fei.uim.oop.assignment3.book.model.Book;
import sk.stuba.fei.uim.oop.assignment3.book.repository.BookRepository;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.author.model.Author;
import sk.stuba.fei.uim.oop.assignment3.author.service.AuthorService;

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
    public Book addBook(BookRequest request) throws NotFoundException{
        Author author = authorService.getAuthorById(request.getAuthor());
        var book = new Book(request, author);
        author.getBooks().add(book);
        return bookRepository.save(book);
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
        if (updateRequest.getAuthor() != null && updateRequest.getAuthor() != 0) {
            var author = authorService.getAuthorById(updateRequest.getAuthor());
            book.setAuthor(author);
        }
        if (updateRequest.getPages() != null && updateRequest.getPages() != 0) {
            book.setPages(updateRequest.getPages());
        }
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) throws NotFoundException {
        Book book = getBookById(id);
        book.getAuthor().getBooks().remove(book);
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
    public Integer addBookAmount(Long id, BookAmount bookAmount) throws NotFoundException {
        var book = getBookById(id);
        if (bookAmount != null && bookAmount.getAmount() != null) {
            book.setAmount(book.getAmount() + bookAmount.getAmount());
        }
        return book.getAmount();
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
