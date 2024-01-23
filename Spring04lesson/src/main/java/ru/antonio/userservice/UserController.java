package ru.antonio.userservice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String listUsers (Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser (@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "profile";
    }

    @PostMapping
    public User addUser (@RequestBody User user){
        return userService.saveUser(user);
    }
}
