package com.example.Steppin.repositories;

import com.example.Steppin.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Steppin.models.Product;
import com.example.Steppin.models.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findUserById(Long id);

    /*List<Product> productsUser =*/
}
