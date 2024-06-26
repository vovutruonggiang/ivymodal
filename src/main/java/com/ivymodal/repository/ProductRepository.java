package com.ivymodal.repository;

import com.ivymodal.dto.Product.response.ProductDiscountActiveResponse;
import com.ivymodal.entity.Category;
import com.ivymodal.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    boolean existsByName(String name);

    @Query("SELECT p FROM Product p WHERE p.isPromoted = false")
    List<Product> findByIsPromotedWithoutActiveDiscount();

    @Query("SELECT new com.ivymodal.dto.Product.response.ProductDiscountActiveResponse(p.name, p.isPromoted, c.id, d.discount_value, d.discount_type) " +
            "FROM Product p " +
            "JOIN p.category c " +
            "JOIN p.addDiscount ad " +
            "JOIN ad.discount d " +
            "WHERE p.isPromoted = true")
    List<ProductDiscountActiveResponse> findPromotedProducts();

    @Query("SELECT p FROM Product p WHERE p.category.id = :idCategory")
    List<Product> findByCategoryId(String idCategory);

    @Query("SELECT p FROM Product p WHERE p.category3.id = :idCategory3")
    List<Product> findByCategoryId3(String idCategory3);


}
