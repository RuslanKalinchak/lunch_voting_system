package kalinchak.exam.lunch_voting_system.service;

import kalinchak.exam.lunch_voting_system.dao.MenuDao;
import kalinchak.exam.lunch_voting_system.dao.RestaurantDao;
import kalinchak.exam.lunch_voting_system.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final MenuDao menuDao;
    private final RestaurantDao restaurantDao;

    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantDao.save(restaurant);
    }

    public Menu saveMenu(MenuDto menuDto, Long restaurantId) {
        return menuDao.save(createMenu(menuDto, restaurantId));
    }

    private Menu createMenu(MenuDto menuDto, Long restaurantId) {
        Menu menu = new Menu();
        menu.setId(menuDto.getMenuId());
        menu.setName(menuDto.getMenuName());
        menu.setDate(LocalDateTime.now());
        menu.setRestaurant(restaurantDao.findRestaurantById(restaurantId));
        menu.setFoods(createFoodSet(menuDto.getFoods(), menuDto.getMenuId()));
        return menu;
    }

    private Set<Food> createFoodSet(List<FoodDto> foods, Long menuId) {
        return foods.stream().map(foodDto -> {
                    Food food = new Food();
                    food.setFoodId(foodDto.getFoodId());
                    food.setFoodName(foodDto.getFoodName());
                    food.setPrice(foodDto.getPrice());
                    food.setMenu(menuDao.findMenuById(menuId));
                    return food;
                }
        ).collect(Collectors.toSet());
    }
}
