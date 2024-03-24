package com.example.Steppin.controllers;

import org.springframework.ui.Model;
import com.example.Steppin.models.User;
import com.example.Steppin.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)) {
            model.addAttribute("errorMessage", "Пользователь с email: " + user.getEmail() + " уже существует ");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }


    @GetMapping("/hello")
    public String securityUrl() {
        return "hello";
    }

}
