package kalinchak.exam.lunch_voting_system.service;

import kalinchak.exam.lunch_voting_system.dao.MenuDao;
import kalinchak.exam.lunch_voting_system.dao.RoleDao;
import kalinchak.exam.lunch_voting_system.dao.UserDao;
import kalinchak.exam.lunch_voting_system.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final RoleDao roleDao;
    private final MenuDao menuDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public List<MenuDto> getMenuList() {
        return getActualMenuList().stream().map(menu -> {
            MenuDto menuDto = new MenuDto();
            menuDto.setMenuId(menu.getId());
            menuDto.setMenuName(menu.getMenuName());
            menuDto.setFoods(createFoodDtoList(menu.getFoods()));
            return menuDto;
        }).collect(Collectors.toList());
    }

    private List<Menu> getActualMenuList() {
        return menuDao.findAllByDate(LocalDateTime.now());
    }

    private List<FoodDto> createFoodDtoList(Set<Food> foods) {
        return foods.stream().map(food -> {
            FoodDto foodDto = new FoodDto();
            foodDto.setFoodId(food.getFoodId());
            foodDto.setFoodName(food.getFoodName());
            foodDto.setPrice(food.getPrice());
            return foodDto;
        }).collect(Collectors.toList());
    }
}
