package com.ivymodal.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Entity
@Table(name = "product")
public class Product extends BaseEntity {
    String name;
    String description;
    String thumbnail;
    Boolean isPromoted = false;

    @ManyToOne
    @JoinColumn(name = "id_category")
    Category category;

    @OneToMany(mappedBy = "product")
    List<ProductVariant> productVariant;

    @OneToMany(mappedBy = "product")
    List<ProductImage> productImage;

    @OneToMany(mappedBy = "product")
    List<AddDiscount> addDiscount;
}
