package kalinchak.exam.lunch_voting_system.service;

import kalinchak.exam.lunch_voting_system.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
