package com.ivymodal.controller.admin.api;

import com.ivymodal.dto.ApiResponse;
import com.ivymodal.dto.ProductVariantImages.request.ProductVariantImagesRequest;
import com.ivymodal.dto.ProductVariantImages.response.ProductVariantImagesResponse;
import com.ivymodal.service.impl.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-admin-product")
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@RequiredArgsConstructor
public class ProductAPI {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ApiResponse<ProductVariantImagesResponse> createProduct(@RequestBody ProductVariantImagesRequest request) {
        ApiResponse<ProductVariantImagesResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.createProduct(request));
        return apiResponse;
    }

}
