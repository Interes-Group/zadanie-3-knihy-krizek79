package sk.stuba.fei.uim.oop.assignment3.service.impl;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.model.List;
import sk.stuba.fei.uim.oop.assignment3.repository.ListRepository;
import sk.stuba.fei.uim.oop.assignment3.service.api.ListService;
import sk.stuba.fei.uim.oop.assignment3.wrapper.request.BookIdRequest;

@Service
public class ListServiceImpl implements ListService {

    private final ListRepository listRepository;

    public ListServiceImpl(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @Override
    public List addList() {
        return null;
    }

    @Override
    public Long addBookToList(BookIdRequest request) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteList(Long id) throws NotFoundException {

    }

    @Override
    public void deleteBookFromList(BookIdRequest request) throws NotFoundException {

    }

    @Override
    public java.util.List<List> getAllLists() {
        return null;
    }

    @Override
    public List getListById() throws NotFoundException {
        return null;
    }

    @Override
    public void lendList(Long id) throws NotFoundException {

    }
}
