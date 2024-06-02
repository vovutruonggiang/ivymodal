package com.ivymodal.dto.ProductVariantImages.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductListResponse {
    List<ProductVariantImagesResponse> productList;
}
