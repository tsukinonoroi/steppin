package com.example.Steppin.services;

import com.example.Steppin.models.Cart;
import com.example.Steppin.models.User;
import com.example.Steppin.models.enums.Role;
import com.example.Steppin.repositories.CartRepository;
import com.example.Steppin.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import java.awt.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CartRepository cartRepository;

    public boolean createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) return false;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_ADMIN);

        Cart cart = new Cart();
        cart.setUser(user);
        user.setCart(cart);

        userRepository.save(user);
        cartRepository.save(cart);
        log.info("Saving new User with email " + user.getEmail());
        log.info("Save new user with cart + " + user.getCart().getId());
        return true;
    }

    public List<User> list() {
        return userRepository.findAll();
    }

    public void banUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user != null) {
            user.setActive(false);
            log.info("Ban user with id = {} ; email {}", user.getId(),user.getEmail());
        }
        userRepository.save(user);
    }
}
