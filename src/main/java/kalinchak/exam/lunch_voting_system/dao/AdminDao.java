package kalinchak.exam.lunch_voting_system.dao;

import kalinchak.exam.lunch_voting_system.model.Menu;
import kalinchak.exam.lunch_voting_system.model.Restaurant;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {

    Restaurant saveRestaurant(Restaurant restaurant);

    Restaurant findRestaurantById(Long restaurantId);

    Menu saveMenu(Menu menu);

    Menu findMenuById(Long menuId);

}
