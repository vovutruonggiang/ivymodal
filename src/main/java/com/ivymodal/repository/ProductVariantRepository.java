package com.ivymodal.repository;

import com.ivymodal.entity.ProductEntity;
import com.ivymodal.entity.ProductVariantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductVariantRepository extends CrudRepository<ProductVariantEntity, Integer> {
    @Query("SELECT pv FROM ProductVariantEntity pv WHERE pv.product.id = :id")
    List<ProductVariantEntity> findProductVariantByIDProduct(int id);
}
