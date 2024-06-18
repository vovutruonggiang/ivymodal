package com.ivymodal.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults (level = AccessLevel.PRIVATE)
@Data
@Entity
@Table(name = "add_discount")
public class AddDiscount extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "id_discount")
    Discount discount;

    @ManyToOne
    @JoinColumn(name = "id_product")
    Product product;
}
