package com.example.Steppin.controllers;

import com.example.Steppin.models.Cart;
import com.example.Steppin.models.Product;
import com.example.Steppin.services.CartService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.Steppin.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    private final ProductService productService;
    private final CartService cartService;

    public CartController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("id") Long id, HttpSession session) {
        Product product = productService.getProductById(id);

        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        if (product != null) {
            cartService.addProductToCart(cart, product);
        }

        return "redirect:/products";
    }

}

