package kalinchak.exam.lunch_voting_system.dao;

import kalinchak.exam.lunch_voting_system.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuDao extends JpaRepository<Menu, Long> {

    Menu save(Menu menu);

    Menu findMenuById(Long menuId);
}
