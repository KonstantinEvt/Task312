package com.crud.UserCrud.controller;


import com.crud.UserCrud.model.UserCrud;
import com.crud.UserCrud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("usersList", userService.getListUsers());
        return "userData";
    }

    @GetMapping("/add")
    public String getViewToAddUser(ModelMap model) {
        model.addAttribute("useradd", new UserCrud());
        return "userAdd";
    }

    @PostMapping("/persist")
    public String addUser(@ModelAttribute("useradd") UserCrud userCrud) {
        userService.addUser(userCrud);
        return "redirect:/all";
    }

    @GetMapping("/update/{id}")
    public String getViewToUpdateUser(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("updateUser", userService.getUser(id));
        return "userUpdate";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("updateUser") UserCrud userCrud, @PathVariable("id") Long id) {
        userService.updateUser(userCrud, id);
        return "redirect:/all";
    }

    @DeleteMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/all";
    }
}