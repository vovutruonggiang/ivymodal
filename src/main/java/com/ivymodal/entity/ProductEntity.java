package com.ivymodal.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {
    String name;
    String description;
    String thumbnail;
    @OneToMany(mappedBy = "product")
    List<ProductVariantEntity> productVariant;

    @ManyToOne
    @JoinColumn(name = "id_category")
    CategoryEntity category;

    @OneToMany(mappedBy = "product")
    List<ProductImageEntity> productImage;

    @OneToMany(mappedBy = "product")
    List<AddDiscountEntity> addDiscount;
}
