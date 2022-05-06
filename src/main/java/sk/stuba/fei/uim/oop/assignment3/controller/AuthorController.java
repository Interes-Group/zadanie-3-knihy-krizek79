package sk.stuba.fei.uim.oop.assignment3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.dto.request.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.dto.response.AuthorResponse;
import sk.stuba.fei.uim.oop.assignment3.dto.updateRequest.AuthorUpdateRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.service.api.AuthorService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> addAuthor(@RequestBody AuthorRequest request) {
        return new ResponseEntity<>(new AuthorResponse(authorService.addAuthor(request)),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponse> updateAuthor(@PathVariable("id") Long id,
                                                       @RequestBody AuthorUpdateRequest updateRequest) throws NotFoundException {
        return new ResponseEntity<>(new AuthorResponse(authorService.updateAuthor(id, updateRequest)),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable("id") Long id) throws NotFoundException {
        authorService.deleteAuthor(id);
    }

    @GetMapping
    public List<AuthorResponse> getAllAuthors() {
        return authorService.getAllAuthors()
                .stream()
                .map(AuthorResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthorById(@PathVariable("id") Long id) throws NotFoundException {
        return new ResponseEntity<>(new AuthorResponse(authorService.getAuthorById(id)),
                HttpStatus.OK);
    }
}
