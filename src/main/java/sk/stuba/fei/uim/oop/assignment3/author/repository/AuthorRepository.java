package sk.stuba.fei.uim.oop.assignment3.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.stuba.fei.uim.oop.assignment3.author.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findAuthorById(Long id);
}
