package sk.stuba.fei.uim.oop.assignment3.service.impl;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.repository.ListRepository;
import sk.stuba.fei.uim.oop.assignment3.service.api.ListService;

@Service
public class ListServiceImpl implements ListService {

    private final ListRepository listRepository;

    public ListServiceImpl(ListRepository listRepository) {
        this.listRepository = listRepository;
    }
}
