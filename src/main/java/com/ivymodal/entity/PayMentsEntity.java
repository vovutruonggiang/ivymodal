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
//import java.util.Date;
//
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Data
//@Entity
//@Table(name = "payments")
//public class PayMentsEntity extends BaseEntity{
//    @ManyToOne
//    @JoinColumn(name = "id_orders")
//    OrdersEntity orders;
//
//    Float amount;
//    Date payment_date;
//    String payment_method;
//    int transactionID;
//}
