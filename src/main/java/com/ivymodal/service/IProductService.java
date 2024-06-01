package com.ivymodal.service;

import com.ivymodal.dto.ProductVariantImages.request.ProductVariantImagesRequest;
import com.ivymodal.dto.ProductVariantImages.response.ProductListResponse;
import com.ivymodal.dto.ProductVariantImages.response.ProductVariantImagesResponse;

public interface IProductService {
    ProductVariantImagesResponse createProduct(ProductVariantImagesRequest request);
    ProductVariantImagesResponse updateProduct(String productId,ProductVariantImagesRequest request);
    ProductListResponse getProductList();
}
