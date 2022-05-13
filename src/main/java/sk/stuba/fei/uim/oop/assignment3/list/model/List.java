package sk.stuba.fei.uim.oop.assignment3.list.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.model.Book;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private java.util.List<Book> lendingList;

    private Boolean lended;
}
