package com.ivymodal.controller.web.api;

import com.ivymodal.dto.ApiResponse;
import com.ivymodal.dto.Product.response.ProductDto;
import com.ivymodal.dto.Product.response.ProductResponse;
import com.ivymodal.service.admin.impl.ProductService;
import com.ivymodal.service.web.impl.ProductWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-website-product")
public class ProductWebsiteAPI {
    @Autowired
    private ProductWebService productService;
    @GetMapping
    public ApiResponse<List<ProductDto>> getAllProduct(){
        ApiResponse<List<ProductDto>>apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.getAllProduct());
        return apiResponse;
    }

}
