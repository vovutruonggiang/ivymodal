package com.ivymodal.dto.ProductVariantImages.request;

import com.ivymodal.dto.Product.request.ProductRequest;
import com.ivymodal.dto.ProductImages.request.ProductImagesRequest;
import com.ivymodal.dto.ProductVariant.request.ProductVariantRequest;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductVariantImagesRequest {
    ProductRequest product;
    List<ProductVariantRequest> productVariant;
    List<ProductImagesRequest> productImage;
}
