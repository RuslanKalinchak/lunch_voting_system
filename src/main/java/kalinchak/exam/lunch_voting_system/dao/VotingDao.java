package kalinchak.exam.lunch_voting_system.dao;

import kalinchak.exam.lunch_voting_system.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VotingDao extends JpaRepository<Voting, Long> {

    Voting save(Voting voting);

    @Query(value = "SELECT v.MENU_ID, COUNT(*) FROM VOTING_SYSTEM v WHERE v.VOTING_DATE = CURRENT_DATE GROUP BY v.MENU_ID ORDER BY v DESC LIMIT 1", nativeQuery = true)
    Long findFirstMenuId();

}
