package sk.stuba.fei.uim.oop.assignment3.service.api;

import javassist.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.wrapper.request.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.wrapper.updateRequest.AuthorUpdateRequest;
import sk.stuba.fei.uim.oop.assignment3.model.Author;

import java.util.List;

public interface AuthorService {

    Author addAuthor(AuthorRequest request);
    Author updateAuthor(Long id, AuthorUpdateRequest updateRequest) throws NotFoundException;
    void deleteAuthor(Long id) throws NotFoundException;
    List<Author> getAllAuthors();
    Author getAuthorById(Long id) throws NotFoundException;
}
