package com.ivymodal.controller.admin.api;

import com.ivymodal.dto.ApiResponse;
import com.ivymodal.dto.Discount.request.DiscountDeleteRequest;
import com.ivymodal.dto.Discount.request.DiscountRequest;
import com.ivymodal.dto.Discount.response.DiscountResponse;
import com.ivymodal.service.impl.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-admin-discount")
public class DiscountAPI {
    @Autowired
    private DiscountService discountService;


    @PostMapping
    public ApiResponse<DiscountResponse> createDiscount(@RequestBody DiscountRequest request) {
        ApiResponse<DiscountResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(discountService.createDiscount(request));
        return apiResponse;
    }

    @PutMapping("{discountId}")
    public ApiResponse<DiscountResponse> updateDiscount(@PathVariable String discountId, @RequestBody DiscountRequest request) {
        ApiResponse<DiscountResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(discountService.updateDiscount(discountId, request));
        return apiResponse;
    }

    @DeleteMapping
    public ApiResponse<DiscountResponse> deleteDiscount(@RequestBody DiscountDeleteRequest request) {
        ApiResponse<DiscountResponse> apiResponse = new ApiResponse<>();
        discountService.deleteDiscount(request.getDiscountIds());
        apiResponse.setMessage("Delete discount successful");
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<DiscountResponse>> getAllDiscount() {
        ApiResponse<List<DiscountResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(discountService.getAllDiscounts());
        return apiResponse;
    }

    @GetMapping("{discountId}")
    public ApiResponse<DiscountResponse> getDiscount(@PathVariable String discountId) {
        ApiResponse<DiscountResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(discountService.getOneDiscount(discountId));
        return apiResponse;
    }
}
