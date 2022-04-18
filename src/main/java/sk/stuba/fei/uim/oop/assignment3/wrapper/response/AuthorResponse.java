package sk.stuba.fei.uim.oop.assignment3.wrapper.response;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.model.Author;
import sk.stuba.fei.uim.oop.assignment3.model.Book;

import java.util.List;

@Getter
public class AuthorResponse {

    private final Long id;
    private final String name;
    private final String surname;
    private final List<Book> books;

    public AuthorResponse(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.surname = author.getSurname();
        this.books = author.getBooks();
    }
}
