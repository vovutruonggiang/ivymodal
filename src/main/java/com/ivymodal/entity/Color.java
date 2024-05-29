package com.ivymodal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Entity
@Table(name = "color")
public class Color extends BaseEntity{
    String name;
    String color_coding;

    @OneToMany(mappedBy = "color")
    List<ProductVariant> productVariant;

    @OneToMany(mappedBy = "color")
    List<ProductImage> productsProductImage;
}
