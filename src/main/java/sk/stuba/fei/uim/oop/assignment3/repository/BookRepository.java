package sk.stuba.fei.uim.oop.assignment3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.stuba.fei.uim.oop.assignment3.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookById(Long id);
}
