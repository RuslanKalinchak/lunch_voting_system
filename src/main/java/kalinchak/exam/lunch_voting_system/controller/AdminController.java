package kalinchak.exam.lunch_voting_system.controller;

import kalinchak.exam.lunch_voting_system.model.Menu;
import kalinchak.exam.lunch_voting_system.model.MenuDto;
import kalinchak.exam.lunch_voting_system.model.Restaurant;
import kalinchak.exam.lunch_voting_system.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Secured("ROLE_ADMIN")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @RequestMapping(value = "/restaurant", method = RequestMethod.POST)
    @ResponseBody
    Restaurant saveRestaurant(@RequestBody Restaurant restaurant) {
        return adminService.saveRestaurant(restaurant);
    }

    @RequestMapping(value = "/restaurant/{id}/menu", method = RequestMethod.POST)
    @ResponseBody
    Menu saveMenu(@RequestBody MenuDto menu,
                  @PathVariable(value = "id") Long restaurantId) {
        return adminService.saveMenu(menu, restaurantId);
    }
}
