package com.example.Steppin.controllers;

import com.example.Steppin.models.Cart;
import com.example.Steppin.models.Product;
import com.example.Steppin.repositories.CartRepository;
import com.example.Steppin.repositories.UserRepository;
import com.example.Steppin.services.CartService;
import com.example.Steppin.services.ProductService;
import org.springframework.ui.Model;
import com.example.Steppin.models.User;
import com.example.Steppin.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

}
