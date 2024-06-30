package com.ivymodal.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Entity
@Table(name = "product_variant")
public class ProductVariant extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "id_product")
    Product product;

    @ManyToOne
    @JoinColumn(name = "id_color")
    Color color;

    @ManyToOne
    @JoinColumn(name = "id_size")
    Size size;

    Double price;
    Boolean status;
    int stock;


    @OneToMany(mappedBy = "productVariant")
    List<Cart> cart;
}
