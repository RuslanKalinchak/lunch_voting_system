package kalinchak.exam.lunch_voting_system.service;

import kalinchak.exam.lunch_voting_system.model.MenuDto;
import kalinchak.exam.lunch_voting_system.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void save(User user);

    User findByUsername(String username);

    List<MenuDto> getMenuList();
}
