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
//@Entity
//@Data
//@Table(name = "orders")
//public class OrdersEntity extends BaseEntity{
//    @ManyToOne
//    @JoinColumn(name = "id_user")
//    UserEntity user;
//
//    Date order_date;
//    Float total_price;
//    String order_status;
//
//    @OneToMany(mappedBy = "orders")
//    List<OrderDetailEntity> orderDetail;
//
//    @OneToMany(mappedBy = "orders")
//    List<PayMentsEntity> payMents;
//}
