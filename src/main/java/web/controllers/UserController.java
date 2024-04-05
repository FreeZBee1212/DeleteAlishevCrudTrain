package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("index", userService.getUsers());
        return "users/index";
    }

    @GetMapping("/id")
    public String showId(@RequestParam("id") int id, Model model) {
        model.addAttribute("show", userService.showOneUser(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String createNewUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/id/edit")
    public String edit(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.showOneUser(id));
        return "users/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("person") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        User userDelete = userService.showOneUser(id);
        userService.deleteUser(userDelete);
        return "redirect:/users";
    }
}
