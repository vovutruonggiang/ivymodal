package com.ivymodal.dto.Product.response;

import com.ivymodal.dto.BaseDTO;
import com.ivymodal.dto.Category.response.CategoryResponse;
import com.ivymodal.dto.ProductImages.response.ProductImagesResponse;
import com.ivymodal.dto.ProductVariant.response.ProductVariantResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse extends BaseDTO {
    String name;
    String description;
    String thumbnail;
    Boolean isPromoted;
    CategoryResponse category;
    List<ProductVariantResponse> productVariants;
    List<ProductImagesResponse> productImages;
}
