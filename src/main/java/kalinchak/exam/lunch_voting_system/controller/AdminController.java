package kalinchak.exam.lunch_voting_system.controller;

import kalinchak.exam.lunch_voting_system.model.Menu;
import kalinchak.exam.lunch_voting_system.model.MenuDto;
import kalinchak.exam.lunch_voting_system.model.Restaurant;
import kalinchak.exam.lunch_voting_system.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@Secured("ROLE_ADMIN")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/restaurant")
    @ResponseBody
    Restaurant saveRestaurant(@RequestBody Restaurant restaurant) {
        return adminService.saveRestaurant(restaurant);
    }

    @PostMapping("/restaurant/{id}/menu")
    @ResponseBody
    Menu saveMenu(@RequestBody MenuDto menu,
                  @PathVariable(value = "id") Long restaurantId) {
        return adminService.saveMenu(menu, restaurantId);
    }




}
