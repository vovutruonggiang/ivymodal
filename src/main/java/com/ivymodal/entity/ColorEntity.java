package com.ivymodal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Entity
@Table(name = "color")
public class ColorEntity extends BaseEntity{
    String name;
    String color_coding;
    @OneToMany(mappedBy = "color")
    List<ProductVariantEntity> productVariants;

    @OneToMany(mappedBy = "color")
    List<ProductImageEntity> productsProductImage;
}
