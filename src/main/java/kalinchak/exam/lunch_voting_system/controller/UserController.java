package kalinchak.exam.lunch_voting_system.controller;

import kalinchak.exam.lunch_voting_system.model.*;
import kalinchak.exam.lunch_voting_system.service.AdminService;
import kalinchak.exam.lunch_voting_system.service.SecurityService;
import kalinchak.exam.lunch_voting_system.service.UserService;
import kalinchak.exam.lunch_voting_system.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final SecurityService securityService;
    private final UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }
        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/menu-list", method = RequestMethod.GET)
    public List<MenuDto> getMenuList() {
        return userService.getMenuList();
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/voting", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity doVote(@RequestBody VotingDto votingDto) {
        LocalTime currentTime = LocalTime.now();
        LocalTime endTime = LocalTime.of(11, 00, 01);
        if (currentTime.isAfter(endTime)) {
            return new ResponseEntity("You late. You can vote tomorrow", HttpStatus.OK);
        } else {
            userService.doVote(votingDto);
            return new ResponseEntity("Your vote has been counted", HttpStatus.OK);
        }
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/voting-result", method = RequestMethod.GET)
    public Menu getWinnerMenu() {
        return userService.getWinnerMenu();
    }

    private final AdminService adminService;

    @RequestMapping(value = "/restaurant", method = RequestMethod.POST)
    @ResponseBody
    Menu saveMenu(@RequestBody MenuDto menu,
                  @PathVariable(value = "id") Long restaurantId) {
        return adminService.saveMenu(menu, restaurantId);
    }
}
