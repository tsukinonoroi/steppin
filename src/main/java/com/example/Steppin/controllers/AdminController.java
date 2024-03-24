package com.example.Steppin.controllers;

import com.example.Steppin.services.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import com.example.Steppin.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor

public class AdminController {
    private final UserService userService;
    private final ProductService productService;


    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("users", userService.list());
        model.addAttribute("products", productService.list());
        return "admin";
    }


    @PostMapping("/user/ban/{id}")
    public String userBan(@PathVariable("id") Long id) {
        userService.banUser(id);
        return "redirect:/admin";
    }
}
