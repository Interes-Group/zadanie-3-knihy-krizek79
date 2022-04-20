package sk.stuba.fei.uim.oop.assignment3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.stuba.fei.uim.oop.assignment3.model.List;

public interface ListRepository extends JpaRepository<List, Long> {

    List getListById(Long id);
}
