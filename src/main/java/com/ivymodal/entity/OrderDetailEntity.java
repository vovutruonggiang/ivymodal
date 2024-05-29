//package com.ivymodal.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.AccessLevel;
//import lombok.Data;
//import lombok.experimental.FieldDefaults;
//
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Data
//@Entity
//@Table(name="orders_detail")
//public class OrderDetailEntity extends BaseEntity{
//    @ManyToOne
//    @JoinColumn(name = "id_orders")
//    OrdersEntity orders;
//
//    @ManyToOne
//    @JoinColumn(name = "id_product_variant")
//    ProductVariantEntity productVariantEntity;
//
//    int quantity;
//    Float price;
//}
