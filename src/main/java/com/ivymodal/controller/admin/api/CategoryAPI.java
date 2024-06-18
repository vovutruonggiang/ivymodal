package com.ivymodal.controller.admin.api;

import com.ivymodal.dto.ApiResponse;
import com.ivymodal.dto.Category.request.CategoryDeleteRequest;
import com.ivymodal.dto.Category.request.CategoryRequest;
import com.ivymodal.dto.Category.response.CategoryResponse;
import com.ivymodal.service.ICategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api-admin-category")
public class CategoryAPI {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ApiResponse<List<CategoryResponse>> getAllCategories(){
        ApiResponse<List<CategoryResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(categoryService.getAllCategories());
        return apiResponse;
    }

//    @GetMapping("/category1")
//    public ApiResponse<List<CategoryResponse>> getCategory1(){
//        ApiResponse<List<CategoryResponse>> apiResponse = new ApiResponse<>();
//        apiResponse.setResult(categoryService.getCategory1());
//        return apiResponse;
//    }

    @GetMapping("/{categoryId}")
    public ApiResponse<CategoryResponse> getCategoryById(@PathVariable("categoryId") String categoryId){
        ApiResponse<CategoryResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(categoryService.getOneCategory(categoryId));
        return apiResponse;
    }

    @PostMapping
    ApiResponse<CategoryResponse> createCategory(@RequestBody CategoryRequest request) {
        ApiResponse<CategoryResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(categoryService.createCategory(request));
        return apiResponse;
    }

    @PutMapping("/{categoryId}")
    public ApiResponse<CategoryResponse> updateCategory(@PathVariable ("categoryId") String categoryId, @RequestBody CategoryRequest request) {
        ApiResponse<CategoryResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(categoryService.updateCategory(categoryId, request));
        return apiResponse;
    }

    @DeleteMapping
    public ApiResponse<Void> deleteCategory(@RequestBody CategoryDeleteRequest request) {
        ApiResponse<Void> apiResponse = new ApiResponse<>();
        categoryService.deleteCategory(request.getIds());
        apiResponse.setMessage("delete success");
        return apiResponse;
    }

    @GetMapping("/structured")
    public Map<String, Map<String, List<Map<String, String>>>> getStructuredCategories() {
        return categoryService.getCategories();
    }
}
