package com.ivymodal.dto.ProductVariantImages.response;

import com.ivymodal.dto.Product.response.ProductResponse;
import com.ivymodal.dto.ProductVariant.response.ProductVariantResponse;
import com.ivymodal.dto.ProductVariantImages.request.ProductVariantImagesRequest;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductVariantImagesResponse{
    ProductResponse product;
    List<ProductVariantResponse> productVariant;
    List<ProductVariantImagesRequest> productVariantImages;
}
