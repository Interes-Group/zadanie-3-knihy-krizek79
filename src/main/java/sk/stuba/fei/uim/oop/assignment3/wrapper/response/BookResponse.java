package sk.stuba.fei.uim.oop.assignment3.wrapper.response;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.model.Book;

@Getter
public class BookResponse {

    private final Long id;
    private final String name;
    private final String description;
    private final Long authorId;
    private final Integer pages;
    private final Integer amount;
    private final Integer lendCount;

    public BookResponse(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.description = book.getDescription();
        this.authorId = book.getAuthor().getId();
        this.pages = book.getPages();
        this.amount = book.getAmount();
        this.lendCount = book.getLendCount();
    }
}
