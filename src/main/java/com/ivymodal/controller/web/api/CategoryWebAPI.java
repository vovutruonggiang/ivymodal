package com.ivymodal.controller.web.api;

import com.ivymodal.dto.ApiResponse;
import com.ivymodal.dto.Category.response.CategoryResponse;
import com.ivymodal.service.web.ICategoryWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-web-category")
public class CategoryWebAPI {
    @Autowired
    private ICategoryWebService categoryWebService;

    @GetMapping
    public ApiResponse<List<CategoryResponse>> getAllCategory(){
        ApiResponse<List<CategoryResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(categoryWebService.getAllCategories());
        return apiResponse;
    }
}
