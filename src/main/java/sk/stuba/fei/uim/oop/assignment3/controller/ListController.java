package sk.stuba.fei.uim.oop.assignment3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.service.api.ListService;
import sk.stuba.fei.uim.oop.assignment3.wrapper.request.BookIdRequest;
import sk.stuba.fei.uim.oop.assignment3.wrapper.response.ListResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/list")
public class ListController {

    private final ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }

    @PostMapping
    public ResponseEntity<ListResponse> addList() {
        return new ResponseEntity<>(new ListResponse(listService.addList()), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/add")
    public ResponseEntity<ListResponse> addBookToList(@PathVariable("id") Long id,
                                                      @RequestBody BookIdRequest request) throws NotFoundException, IllegalOperationException {
        return new ResponseEntity<>(new ListResponse(listService.addBookToList(id, request)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteList(@PathVariable("id") Long id) throws NotFoundException {
        listService.deleteList(id);
    }

    @DeleteMapping("/{id}/remove")
    public void deleteBookFromList(@PathVariable("id") Long id,
                                   @RequestBody BookIdRequest request) throws NotFoundException {
        listService.deleteBookFromList(id, request);
    }

    @GetMapping
    public List<ListResponse> getAllLists() {
        return listService.getAllLists()
                .stream()
                .map(ListResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListResponse> getListById(@PathVariable("id") Long id) throws NotFoundException {
        return new ResponseEntity<>(new ListResponse(listService.getListById(id)), HttpStatus.OK);
    }

    @GetMapping("/{id}/lend")
    public void lendList(@PathVariable("id") Long id) throws NotFoundException, IllegalOperationException {
        listService.lendList(id);
    }
}
