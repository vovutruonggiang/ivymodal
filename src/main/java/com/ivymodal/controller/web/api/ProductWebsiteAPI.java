package com.ivymodal.controller.web.api;

import com.ivymodal.dto.ApiResponse;
import com.ivymodal.dto.Product.response.ProductDto;
import com.ivymodal.dto.Product.response.ProductResponse;
import com.ivymodal.service.admin.impl.ProductService;
import com.ivymodal.service.web.IProductWebService;
import com.ivymodal.service.web.impl.ProductWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-website-product")
public class ProductWebsiteAPI {
    @Autowired
    private IProductWebService productWebService;


    @GetMapping("/women")
    public ApiResponse<List<ProductDto>> getAllProductWomen(){
        ApiResponse<List<ProductDto>>apiResponse = new ApiResponse<>();
        apiResponse.setResult(productWebService.getAllProductWomen());
        return apiResponse;
    }

    @GetMapping("/men")
    public ApiResponse<List<ProductDto>> getAllProductMen(){
        ApiResponse<List<ProductDto>>apiResponse = new ApiResponse<>();
        apiResponse.setResult(productWebService.getAllProductMen());
        return apiResponse;
    }

    @GetMapping("/by-category/{id_category}")
    public ApiResponse<List<ProductDto>> getAllProductByCategory(@PathVariable String id_category){
        ApiResponse<List<ProductDto>>apiResponse = new ApiResponse<>();
        apiResponse.setResult(productWebService.getAllProductByCategory(id_category));
        return apiResponse;
    }

}
