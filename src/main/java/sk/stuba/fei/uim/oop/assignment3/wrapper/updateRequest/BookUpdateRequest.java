package sk.stuba.fei.uim.oop.assignment3.wrapper.updateRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateRequest {

    private String name;
    private String description;
    private Long authorId;
    private Integer pages;
}
