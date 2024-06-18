package com.ivymodal.repository;

import com.ivymodal.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount,String> {
    Boolean existsByName(String name);
}
