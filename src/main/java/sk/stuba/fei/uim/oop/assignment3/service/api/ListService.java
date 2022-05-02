package sk.stuba.fei.uim.oop.assignment3.service.api;

import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.wrapper.request.BookIdRequest;

import java.util.List;

public interface ListService {

    sk.stuba.fei.uim.oop.assignment3.model.List addList();
    Long addBookToList(BookIdRequest request) throws NotFoundException;
    void deleteList(Long id) throws NotFoundException;
    void deleteBookFromList(BookIdRequest request) throws NotFoundException;
    List<sk.stuba.fei.uim.oop.assignment3.model.List> getAllLists();
    sk.stuba.fei.uim.oop.assignment3.model.List getListById() throws NotFoundException;
    void lendList(Long id) throws NotFoundException;
}
