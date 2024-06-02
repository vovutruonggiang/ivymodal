package com.ivymodal.dto.ProductVariantImages.response;

import com.ivymodal.dto.BaseDTO;
import com.ivymodal.dto.Category.response.CategoryResponse;
import com.ivymodal.dto.Product.response.ProductResponse;
import com.ivymodal.dto.ProductImages.response.ProductImagesResponse;
import com.ivymodal.dto.ProductVariant.response.ProductVariantResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductVariantImagesResponse extends BaseDTO {
    ProductResponse productResponse;
    List<ProductVariantResponse> productVariant;
    List<ProductImagesResponse> productVariantImages;
}
