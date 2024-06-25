    package com.ivymodal.entity;

    import jakarta.persistence.Entity;
    import jakarta.persistence.OneToMany;
    import jakarta.persistence.Table;
    import jakarta.persistence.Column;
    import lombok.AccessLevel;
    import lombok.Data;
    import lombok.experimental.FieldDefaults;

    import java.util.List;

    @Data
    @Entity
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Table(name = "category")
    public class Category extends BaseEntity {
        String name;
        String menu_link;

        @Column(name = "menu_parent_id")
        String menuParentId;

        @OneToMany(mappedBy = "category")
        List<Product> products;

        @OneToMany(mappedBy = "category2")
        List<Product> products2;

        @OneToMany(mappedBy = "category3")
        List<Product> products3;
    }
