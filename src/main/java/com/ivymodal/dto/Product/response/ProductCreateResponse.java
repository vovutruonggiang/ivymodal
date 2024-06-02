package com.ivymodal.dto.Product.response;

import com.ivymodal.dto.Category.response.CategoryResponse;
import com.ivymodal.dto.ProductImages.response.ProductImagesResponse;
import com.ivymodal.dto.ProductVariant.response.ProductVariantResponse;

import java.util.List;

public class ProductCreateResponse {
    String name;
    String description;
    String thumbnail;
    CategoryResponse category;
}
