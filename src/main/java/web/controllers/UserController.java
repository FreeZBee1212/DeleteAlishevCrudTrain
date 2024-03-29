package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("index", userServiceImpl.index());
        return "users/index";
    }

    @GetMapping("/id")
    public String show(@RequestParam("id") int id, Model model) {
        model.addAttribute("show", userServiceImpl.showOneUser(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userServiceImpl.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/id/edit")
    public String edit(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userServiceImpl.showOneUser(id));
        return "users/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("person") User user) {
        userServiceImpl.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String Delete(@RequestParam("id") int id) {
        userServiceImpl.deleteUser(id);
        return "redirect:/users";
    }
}
