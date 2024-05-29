package com.ivymodal.repository;

import com.ivymodal.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductVariantRepository extends JpaRepository<ProductVariant, String> {
}
