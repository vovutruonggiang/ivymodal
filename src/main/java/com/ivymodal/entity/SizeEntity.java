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
@Table(name = "size")
public class SizeEntity extends BaseEntity {
    String name;
    @OneToMany(mappedBy = "size")
    List<ProductVariantEntity> productVariants;
}
