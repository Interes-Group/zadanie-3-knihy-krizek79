package sk.stuba.fei.uim.oop.assignment3.wrapper.response;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ListResponse {

    private final Long id;
    private final List<BookResponse> lendingList;
    private final Boolean lended;

    public ListResponse(sk.stuba.fei.uim.oop.assignment3.model.List list) {
        this.id = list.getId();
        this.lendingList = new ArrayList<>();
        this.lended = list.getLended();
    }
}
