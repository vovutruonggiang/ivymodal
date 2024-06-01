package com.ivymodal.controller.admin.api;

import com.ivymodal.dto.ApiResponse;
import com.ivymodal.dto.Product.response.ProductResponse;
import com.ivymodal.dto.ProductVariantImages.request.ProductVariantImagesRequest;
import com.ivymodal.dto.ProductVariantImages.response.ProductListResponse;
import com.ivymodal.dto.ProductVariantImages.response.ProductVariantImagesResponse;
import com.ivymodal.service.impl.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{productId}")
    public ApiResponse<ProductVariantImagesResponse> updateProduct(@PathVariable("productId") String productId,@RequestBody ProductVariantImagesRequest request){
        ApiResponse<ProductVariantImagesResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.updateProduct(productId, request));
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<ProductListResponse> getAllProduct(){
        ApiResponse<ProductListResponse>apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.getProductList());
        return apiResponse;
    }

}
