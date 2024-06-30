package com.ivymodal.repository;

import com.ivymodal.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,String> {
}
