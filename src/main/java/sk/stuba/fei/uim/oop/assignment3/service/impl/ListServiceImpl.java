package sk.stuba.fei.uim.oop.assignment3.service.impl;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.dto.request.BookIdRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.model.Book;
import sk.stuba.fei.uim.oop.assignment3.model.List;
import sk.stuba.fei.uim.oop.assignment3.repository.ListRepository;
import sk.stuba.fei.uim.oop.assignment3.service.api.BookService;
import sk.stuba.fei.uim.oop.assignment3.service.api.ListService;

import java.util.ArrayList;

@Service
public class ListServiceImpl implements ListService {

    private final ListRepository listRepository;
    private final BookService bookService;

    public ListServiceImpl(ListRepository listRepository, BookService bookService) {
        this.listRepository = listRepository;
        this.bookService = bookService;
    }

    @Override
    public List addList() {
        List list = new List();
        list.setLended(false);
        return listRepository.save(list);
    }

    @Override
    public List addBookToList(Long id, BookIdRequest request) throws NotFoundException, IllegalOperationException {
        List list = getListById(id);
        if (list.getLended()) throw new IllegalOperationException();

        Book book = bookService.getBookById(request.getId());
        if (list.getLendingList() != null) {
            for (var book1: list.getLendingList()) {
                if (book1 == book) throw new IllegalOperationException();
            }
        } else {
            list.setLendingList(new ArrayList<>());
        }
        list.getLendingList().add(book);

        return listRepository.save(list);
    }

    @Override
    public void deleteList(Long id) throws NotFoundException {
        List list = getListById(id);
        if (list.getLended()) {
            for (var book: list.getLendingList()) {
                book.setLendCount(book.getLendCount() - 1);
            }
        }
        listRepository.delete(list);
    }

    @Override
    public void deleteBookFromList(Long id, BookIdRequest request) throws NotFoundException {
        List list = getListById(id);
        if (list.getLendingList() != null) {
            for (var book: list.getLendingList()) {
                if (book.getId().equals(request.getId())) {
                    list.getLendingList().remove(book);
                    return;
                }
            }
        }
    }

    @Override
    public java.util.List<List> getAllLists() {
        return listRepository.findAll();
    }

    @Override
    public List getListById(Long id) throws NotFoundException {
        List list = listRepository.findListById(id);
        if (list == null) {
            throw new NotFoundException();
        }
        return list;
    }

    @Override
    public void lendList(Long id) throws NotFoundException, IllegalOperationException {
        List list = getListById(id);
        if (list.getLended()) throw new IllegalOperationException();
        for (var book: list.getLendingList()) {
            book.setLendCount(book.getLendCount() + 1);
        }
        list.setLended(true);
        listRepository.save(list);
    }
}
