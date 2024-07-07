package com.ivymodal.repository;

import com.ivymodal.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductVariantRepository extends JpaRepository<ProductVariant, String> {
    List<ProductVariant> findByProductId(String productId);
    ProductVariant findOneByProductId(String productId);

    @Query("SELECT pv FROM ProductVariant pv where " +
            "pv.product.id = :idProduct and " +
            "pv.color.id = :idColor and " +
            "pv.size.id = :idSize")
    ProductVariant getStockByProductVariant(String idProduct , String idColor, String idSize);
}
