package com.ivymodal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "category")
public class CategoryEntity extends BaseEntity{
    String menu_title;
    String menu_link;

    @OneToMany(mappedBy = "category")
    List<ProductEntity> products;
}
