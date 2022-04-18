package sk.stuba.fei.uim.oop.assignment3.service.impl;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.wrapper.request.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.wrapper.updateRequest.AuthorUpdateRequest;
import sk.stuba.fei.uim.oop.assignment3.model.Author;
import sk.stuba.fei.uim.oop.assignment3.repository.AuthorRepository;
import sk.stuba.fei.uim.oop.assignment3.service.api.AuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author addAuthor(AuthorRequest request) {
        return authorRepository.save(new Author(request));
    }

    @Override
    public Author updateAuthor(Long id, AuthorUpdateRequest updateRequest) throws NotFoundException {
        Author author = getAuthorById(id);
        if (updateRequest.getName() != null) {
            author.setName(updateRequest.getName());
        }
        if (updateRequest.getSurname() != null) {
            author.setSurname(updateRequest.getSurname());
        }
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) throws NotFoundException {
        Author author = getAuthorById(id);
        authorRepository.delete(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) throws NotFoundException {
        return authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(null));
    }
}
