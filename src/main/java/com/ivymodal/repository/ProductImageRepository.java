package com.ivymodal.repository;

import com.ivymodal.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage,String> {
    List<ProductImage> findByProductId(String productId);
    ProductImage findOneByProductId(String productId);
}
