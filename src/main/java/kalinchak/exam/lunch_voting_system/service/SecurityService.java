package kalinchak.exam.lunch_voting_system.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
