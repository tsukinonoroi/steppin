package com.example.Steppin.services;

import com.example.Steppin.models.Cart;
import com.example.Steppin.models.Product;
import com.example.Steppin.repositories.CartRepository;
import com.example.Steppin.repositories.ProductRepository;
import com.example.Steppin.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Steppin.models.User;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartService {



    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    public void addProductToCart(Cart cart, Product product) {
        if (cart.getId() == null) {
            cartRepository.save(cart);
        }
        cart.addProduct(product);
        cartRepository.save(cart);
    }


    public Cart getCartFromUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return user.getCart();
        } else {
            return null;
        }
    }
    public void removeProductFromCart(Cart cart, Product product) {
        cart.removeProduct(product);
        cartRepository.save(cart);
    }

    public Set<Product> getAllProductsInCart(Long id) {
        Cart cart = cartRepository.findById(id).orElse(null);
        if (cart != null) {
            return cart.getProducts();
        } else {
            return null;
        }

    }
}
