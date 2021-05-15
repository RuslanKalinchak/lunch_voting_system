package kalinchak.exam.lunch_voting_system.service;

import org.springframework.stereotype.Service;

@Service
public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
