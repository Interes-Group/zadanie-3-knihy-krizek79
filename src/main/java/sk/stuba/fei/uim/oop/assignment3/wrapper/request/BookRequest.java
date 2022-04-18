package sk.stuba.fei.uim.oop.assignment3.wrapper.request;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.model.Author;

@Getter
@Setter
public class BookRequest {

    private String name;
    private String description;
    private Author author;
    private Integer pages;
    private Integer amount;
    private Integer lendCount;
}
