package kalinchak.exam.lunch_voting_system.dao;

import kalinchak.exam.lunch_voting_system.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDao extends JpaRepository<Restaurant, Long> {

    Restaurant save(Restaurant restaurant);

    Restaurant findRestaurantById(Long restaurantId);
}
