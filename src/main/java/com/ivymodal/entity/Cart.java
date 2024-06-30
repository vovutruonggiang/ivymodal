package com.ivymodal.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Entity
@Table(name = "cart")
public class Cart extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "id_user")
    Users users;

    @ManyToOne
    @JoinColumn(name = "id_product")
    Product product;

    @ManyToOne
    @JoinColumn(name = "id_product_variant")
    ProductVariant productVariant;

    int quantity;
}
