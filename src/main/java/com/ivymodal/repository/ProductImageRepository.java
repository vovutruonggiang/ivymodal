package com.ivymodal.repository;

import com.ivymodal.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage,String> {
    List<ProductImage> findByProductId(String productId);
    ProductImage findOneByProductId(String productId);

    @Query("SELECT i FROM ProductImage i where i.color.id = :idColor and i.product.id = :idProduct")
    Optional<ProductImage> findOneByProductIdAndProductId(String idColor, String idProduct);
}
