package sk.stuba.fei.uim.oop.assignment3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.stuba.fei.uim.oop.assignment3.service.api.ListService;

@Controller
@RequestMapping("/list")
public class ListController {

    private final ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }
}
