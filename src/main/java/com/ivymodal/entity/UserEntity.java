//package com.ivymodal.entity;
//
//import jakarta.persistence.*;
//import lombok.AccessLevel;
//import lombok.Data;
//import lombok.experimental.FieldDefaults;
//
//import java.util.Date;
//import java.util.List;
//
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Data
//@Entity
//@Table(name = "user")
//public class UserEntity extends BaseEntity{
//    String fullname;
//    Date date_of_birth;
//    Boolean gender;
//    String city_of_province;
//    String country_of_district;
//    String ward_of_commune;
//    String adress;
//
//    @OneToOne
//    @JoinColumn(name = "id_account")
//    AccountEntity account;
//
//    @OneToMany(mappedBy = "user")
//    List<OrdersEntity> orders;
//
//    @OneToMany(mappedBy = "user")
//    List<CartEntity> cart;
//}
