package com.ivymodal.controller.admin.api;

import com.ivymodal.dto.ApiResponse;
import com.ivymodal.dto.Product.response.ProductDiscountActiveResponse;
import com.ivymodal.dto.Product.response.ProductDiscountWithoutActiveResponse;
import com.ivymodal.service.admin.IAddDiscountService;
import com.ivymodal.service.admin.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-admin-add-discount")
public class AddDiscountAPI {
    @Autowired
    private IAddDiscountService addDiscountService;

    @Autowired
    private IProductService productService;


    @GetMapping("product-without-active-discount")
    public ApiResponse<List<ProductDiscountWithoutActiveResponse>> getAllProductWithoutActiveDiscount() {
        ApiResponse<List<ProductDiscountWithoutActiveResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.getAllProductWithoutActiveDiscount());
        return apiResponse;
    }

    @GetMapping("product-active-discount")
    public ApiResponse<List<ProductDiscountActiveResponse>> getAllProductActiveDiscount() {
        ApiResponse<List<ProductDiscountActiveResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.getAllProductActiveDiscount());
        return apiResponse;
    }
}
