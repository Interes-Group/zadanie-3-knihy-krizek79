package sk.stuba.fei.uim.oop.assignment3.service.impl;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.model.Book;
import sk.stuba.fei.uim.oop.assignment3.model.List;
import sk.stuba.fei.uim.oop.assignment3.repository.ListRepository;
import sk.stuba.fei.uim.oop.assignment3.service.api.BookService;
import sk.stuba.fei.uim.oop.assignment3.service.api.ListService;
import sk.stuba.fei.uim.oop.assignment3.wrapper.request.BookIdRequest;

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

        Book book = bookService.getBookById(request.getBookId());
        for (var book1: list.getLendingList()) {
            if (book1 == book) throw new IllegalOperationException();
        }
        list.getLendingList().add(book);

        return listRepository.save(list);
    }

    @Override
    public void deleteList(Long id) throws NotFoundException {
        List list = getListById(id);
        listRepository.delete(list);
    }

    @Override
    public void deleteBookFromList(Long id, BookIdRequest request) throws NotFoundException {
        List list = getListById(id);
        list.getLendingList().forEach(book -> {
            if (book.getId().equals(request.getBookId()))
                list.getLendingList().remove(book);
        });
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
