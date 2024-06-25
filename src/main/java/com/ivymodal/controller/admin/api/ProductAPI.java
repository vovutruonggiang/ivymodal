package com.ivymodal.controller.admin.api;

import com.ivymodal.dto.ApiResponse;
import com.ivymodal.dto.Product.request.ProductDeleteRequest;
import com.ivymodal.dto.Product.request.ProductRequest;
import com.ivymodal.dto.Product.response.ProductResponse;
import com.ivymodal.service.admin.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-admin-product")
public class ProductAPI {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ApiResponse<ProductResponse> createProduct(@RequestBody ProductRequest request) {
        ApiResponse<ProductResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.createProduct(request));
        return apiResponse;
    }

    @PutMapping("/{productId}")
    public ApiResponse<ProductResponse> updateProduct(@PathVariable("productId") String productId,@RequestBody ProductRequest request){
        ApiResponse<ProductResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.updateProduct(productId, request));
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<ProductResponse>> getAllProduct(){
        ApiResponse<List<ProductResponse>>apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.getAllProduct());
        return apiResponse;
    }

    @GetMapping("{productId}")
    public ApiResponse<List<ProductResponse>> getOneProduct(@PathVariable ("productId") String productId){
        ApiResponse<List<ProductResponse>>apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.getOneProduct(productId));
        return apiResponse;
    }

    @DeleteMapping("/delete-variant")
    public ApiResponse<ProductResponse> deleteVariant(@RequestBody ProductDeleteRequest request){
        ApiResponse<ProductResponse> apiResponse = new ApiResponse<>();
        productService.DeleteVariant(request.getImagesIds(), request.getVariantIds());
        apiResponse.setMessage("Delete success");
        return apiResponse;
    }

    @DeleteMapping("/delete-product")
    public ApiResponse<ProductResponse> deleteProduct(@RequestBody ProductDeleteRequest request){
        ApiResponse<ProductResponse> apiResponse = new ApiResponse<>();
        productService.DeleteProduct(request.getProductIds());
        apiResponse.setMessage("Delete success");
        return apiResponse;
    }
}
