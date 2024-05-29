//package com.ivymodal.repository;
//
//import com.ivymodal.entity.ProductImageEntity;
//import com.ivymodal.entity.UserEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface UserRepository extends JpaRepository<UserEntity, Integer> {
//    @Query("SELECT u FROM UserEntity u WHERE u.account.id = :id")
//    UserEntity findUserByID(int id);
//
//}
