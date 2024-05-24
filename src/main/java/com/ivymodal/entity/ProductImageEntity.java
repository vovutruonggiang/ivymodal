package com.ivymodal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Entity
@Table(name = "productImage")
public class ProductImageEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "id_product")
    ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "id_color")
    ColorEntity color;

    String image_url;
}
