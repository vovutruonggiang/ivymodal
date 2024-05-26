package com.ivymodal.repository;

import com.ivymodal.entity.ProductEntity;
import com.ivymodal.entity.ProductImageEntity;
import com.ivymodal.entity.ProductVariantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImageEntity,Integer> {
    @Query("SELECT pi FROM ProductImageEntity pi WHERE pi.product.id = :id")
    List<ProductImageEntity> findProductImageByIDProduct(int id);
}
