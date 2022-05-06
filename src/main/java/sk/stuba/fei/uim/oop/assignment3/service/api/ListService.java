package sk.stuba.fei.uim.oop.assignment3.service.api;

import sk.stuba.fei.uim.oop.assignment3.dto.request.BookIdRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

public interface ListService {

    sk.stuba.fei.uim.oop.assignment3.model.List addList();
    sk.stuba.fei.uim.oop.assignment3.model.List addBookToList(Long id, BookIdRequest request) throws NotFoundException, IllegalOperationException;
    void deleteList(Long id) throws NotFoundException;
    void deleteBookFromList(Long id, BookIdRequest request) throws NotFoundException;
    List<sk.stuba.fei.uim.oop.assignment3.model.List> getAllLists();
    sk.stuba.fei.uim.oop.assignment3.model.List getListById(Long id) throws NotFoundException;
    void lendList(Long id) throws NotFoundException, IllegalOperationException;
}
