package kalinchak.exam.lunch_voting_system.service;

import kalinchak.exam.lunch_voting_system.dao.AdminDao;
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
    private final AdminDao adminDao;

    public Restaurant saveRestaurant(Restaurant restaurant) {
        return adminDao.saveRestaurant(restaurant);
    }

    public Menu saveMenu(MenuDto menuDto, Long restaurantId) {
        return adminDao.saveMenu(createMenu(menuDto, restaurantId));
    }

    private Menu createMenu(MenuDto menuDto, Long restaurantId) {
        Menu menu = new Menu();
        menu.setMenuId(menuDto.getMenuId());
        menu.setMenuName(menuDto.getMenuName());
        menu.setMenuDate(LocalDateTime.now());
        menu.setRestaurant(adminDao.findRestaurantById(restaurantId));
        menu.setFoods(createFoodSet(menuDto.getFoods(), menuDto.getMenuId()));
        return menu;
    }

    private Set<Food> createFoodSet(List<FoodDto> foods, Long menuId) {
        return foods.stream().map(foodDto -> {
                    Food food = new Food();
                    food.setFoodId(foodDto.getFoodId());
                    food.setFoodName(foodDto.getFoodName());
                    food.setPrice(foodDto.getPrice());
                    food.setMenu(adminDao.findMenuById(menuId));
                    return food;
                }
        ).collect(Collectors.toSet());
    }
}
