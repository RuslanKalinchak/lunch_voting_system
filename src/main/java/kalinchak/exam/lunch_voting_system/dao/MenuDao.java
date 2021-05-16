package kalinchak.exam.lunch_voting_system.dao;

import kalinchak.exam.lunch_voting_system.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MenuDao extends JpaRepository<Menu, Long> {

    Menu save(Menu menu);

    Menu findMenuById(Long menuId);

    List<Menu> findAllByDate (LocalDateTime dateTime);

    Menu findMenuByName(String name);
}
