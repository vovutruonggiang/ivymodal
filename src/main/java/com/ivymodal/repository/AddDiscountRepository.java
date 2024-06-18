package com.ivymodal.repository;

import com.ivymodal.entity.AddDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddDiscountRepository extends JpaRepository<AddDiscount,String> {
    @Query("SELECT CASE WHEN COUNT(dp) > 0 THEN true ELSE false END FROM AddDiscount dp WHERE dp.product.id = :productId")
    Boolean existsByProductId(String[] productId);

}
