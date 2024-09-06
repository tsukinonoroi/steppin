package com.example.Steppin.services;

import com.example.Steppin.models.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CurrentUserService {
    public User getCurrentUser(HttpSession session) {
        return (User) session.getAttribute("user");
    }
}
