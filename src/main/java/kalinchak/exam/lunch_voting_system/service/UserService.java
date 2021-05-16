package kalinchak.exam.lunch_voting_system.service;

import kalinchak.exam.lunch_voting_system.model.Menu;
import kalinchak.exam.lunch_voting_system.model.MenuDto;
import kalinchak.exam.lunch_voting_system.model.User;
import kalinchak.exam.lunch_voting_system.model.Voting;
import kalinchak.exam.lunch_voting_system.model.VotingDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void save(User user);

    User findByUsername(String username);

    List<MenuDto> getMenuList();

    Voting doVote(VotingDto votingDto);

    Menu getWinnerMenu();
}
