package com.example.Steppin.repositories;

import com.example.Steppin.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface imageRepository extends JpaRepository<Image, Long> {
}
