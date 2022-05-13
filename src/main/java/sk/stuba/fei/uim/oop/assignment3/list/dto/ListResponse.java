package sk.stuba.fei.uim.oop.assignment3.list.dto;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.book.dto.BookResponse;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ListResponse {

    private final Long id;
    private final List<BookResponse> lendingList;
    private final Boolean lended;

    public ListResponse(sk.stuba.fei.uim.oop.assignment3.list.model.List list) {
        this.id = list.getId();
        this.lendingList = new ArrayList<>();
        if (list.getLendingList() != null) {
            list.getLendingList().forEach(book -> lendingList.add(new BookResponse(book)));
        }
        this.lended = list.getLended();
    }
}
