package sk.stuba.fei.uim.oop.assignment3.list.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.stuba.fei.uim.oop.assignment3.list.model.List;

public interface ListRepository extends JpaRepository<List, Long> {

    List findListById(Long id);
}
