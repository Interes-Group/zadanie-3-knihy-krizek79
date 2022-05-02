package sk.stuba.fei.uim.oop.assignment3.wrapper.response;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.model.Author;

import java.util.ArrayList;
import java.util.List;

@Getter
public class AuthorResponse {

    private final Long id;
    private final String name;
    private final String surname;
    private final List<Long> books;

    public AuthorResponse(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.surname = author.getSurname();
        this.books = new ArrayList<>();
        for (var book: author.getBooks()) {
            this.books.add(book.getId());
        }
    }
}
