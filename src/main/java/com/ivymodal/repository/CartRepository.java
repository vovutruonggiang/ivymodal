package com.ivymodal.repository;

import com.ivymodal.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,String> {
    @Query("SELECT c FROM Cart c WHERE c.users.id = :idUser")
    List<Cart> findByCustomerId(String idUser);

//    @Query("SELECT SUM(c.quantity) FROM Cart c where c.productVariant.id = :idProductVariant")
//    Cart quantityByProductVariant(String idProductVariant);

    @Query("SELECT SUM(c.quantity) FROM Cart c WHERE c.productVariant.id = :idProductVariant")
    Integer quantityByProductVariant(String idProductVariant);

    @Query("SELECT c FROM Cart c WHERE " +
            "c.users.id = :idUser and " +
            "c.product.id = :idProduct and " +
            "c.productVariant.id = :idVariant ")
    Cart findCartByIdUserAndProductAndVariant(String idUser,String idProduct, String idVariant);

}
