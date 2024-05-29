package com.ivymodal.service;

import com.ivymodal.dto.ProductVariantImages.request.ProductVariantImagesRequest;
import com.ivymodal.dto.ProductVariantImages.response.ProductVariantImagesResponse;

import java.util.List;

public interface IProductService {
    ProductVariantImagesResponse createProduct(ProductVariantImagesRequest request);
}
