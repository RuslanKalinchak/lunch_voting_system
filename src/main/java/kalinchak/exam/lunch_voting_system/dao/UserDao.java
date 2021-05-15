package kalinchak.exam.lunch_voting_system.dao;

import kalinchak.exam.lunch_voting_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
//    @Query ("SELECT s FROM User s where s.username =:username")
    User findByUsername(String username);
}
