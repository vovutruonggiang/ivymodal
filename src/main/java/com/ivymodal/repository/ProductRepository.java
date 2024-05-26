package com.ivymodal.repository;

import com.ivymodal.entity.ProductEntity;
import com.ivymodal.entity.ProductImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    @Query("SELECT p FROM ProductEntity p WHERE p.id = :id")
    List<ProductEntity> findProductByID(int id);
}
