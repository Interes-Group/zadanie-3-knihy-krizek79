package sk.stuba.fei.uim.oop.assignment3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.dto.request.AuthorRequest;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @OneToMany(orphanRemoval = true)
    private List<Book> books;

    public Author(AuthorRequest request) {
        this.name = request.getName();
        this.surname = request.getSurname();
        this.books = new ArrayList<>();
    }
}
