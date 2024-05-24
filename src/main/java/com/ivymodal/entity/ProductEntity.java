    package com.ivymodal.entity;

    import jakarta.persistence.*;
    import lombok.AccessLevel;
    import lombok.Data;
    import lombok.experimental.FieldDefaults;

    import java.util.List;

    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Data
    @Entity
    @Table(name = "product")
    public class ProductEntity extends BaseEntity {
        private String name;
        private String description;
        private String thumbnail;
        private @OneToMany(mappedBy = "product")
        List<ProductVariantEntity> productVariant;
        @ManyToOne
        @JoinColumn(name = "id_category")
        private CategoryEntity category;

        @OneToMany(mappedBy = "product")
        List<ProductImageEntity> productImage;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public List<ProductVariantEntity> getProductVariant() {
            return productVariant;
        }

        public void setProductVariant(List<ProductVariantEntity> productVariant) {
            this.productVariant = productVariant;
        }

        public CategoryEntity getCategory() {
            return category;
        }

        public void setCategory(CategoryEntity category) {
            this.category = category;
        }

        public List<ProductImageEntity> getProductImage() {
            return productImage;
        }

        public void setProductImage(List<ProductImageEntity> productImage) {
            this.productImage = productImage;
        }
    }
