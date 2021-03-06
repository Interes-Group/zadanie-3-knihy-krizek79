package sk.stuba.fei.uim.oop.assignment3.author.service;

import sk.stuba.fei.uim.oop.assignment3.author.dto.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.author.dto.AuthorUpdateRequest;
import sk.stuba.fei.uim.oop.assignment3.author.model.Author;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

public interface AuthorService {

    Author addAuthor(AuthorRequest request);
    Author updateAuthor(Long id, AuthorUpdateRequest updateRequest) throws NotFoundException;
    void deleteAuthor(Long id) throws NotFoundException;
    List<Author> getAllAuthors();
    Author getAuthorById(Long id) throws NotFoundException;
}
