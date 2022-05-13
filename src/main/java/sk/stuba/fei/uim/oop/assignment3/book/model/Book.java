package sk.stuba.fei.uim.oop.assignment3.book.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.author.model.Author;
import sk.stuba.fei.uim.oop.assignment3.book.dto.BookRequest;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    private Author author;

    private Integer pages;

    private Integer amount;

    private Integer lendCount;

    public Book(BookRequest request, Author author) {
        this.name = request.getName();
        this.description = request.getDescription();
        this.author = author;
        this.pages = request.getPages();
        this.amount = request.getAmount();
        this.lendCount = request.getLendCount();
    }
}
