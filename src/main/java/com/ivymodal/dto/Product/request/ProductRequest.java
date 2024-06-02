package com.ivymodal.dto.Product.request;

import com.ivymodal.dto.Category.response.CategoryResponse;
import com.ivymodal.dto.ProductImages.request.ProductImagesRequest;
import com.ivymodal.dto.ProductVariant.request.ProductVariantRequest;
import com.ivymodal.dto.ProductVariant.response.ProductVariantResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {
    String name;
    String description;
    String thumbnail;
    CategoryResponse category;
    List<ProductVariantRequest> productVariants;
    List<ProductImagesRequest> productImages;
}
