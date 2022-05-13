package sk.stuba.fei.uim.oop.assignment3.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.stuba.fei.uim.oop.assignment3.book.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookById(Long id);
}
