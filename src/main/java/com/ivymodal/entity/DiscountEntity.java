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
//@Table(name = "discount")
//public class DiscountEntity extends BaseEntity {
//    String name;
//    Date start_time;
//    Date end_time;
//    String descriptions;
//    String discount_type;
//    Float discount_value;
//    int status;
//
//    @OneToMany(mappedBy = "discount")
//    List<AddDiscountEntity> addDiscountEntities;
//}
