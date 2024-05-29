package com.ivymodal.repository;

import com.ivymodal.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, String> {
    boolean existsByName(String name);
}
