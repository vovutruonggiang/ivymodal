package com.ivymodal.service;

import com.ivymodal.dto.Category.request.CategoryRequest;
import com.ivymodal.dto.Category.response.CategoryResponse;
import com.ivymodal.entity.Category;

import java.util.List;
import java.util.Map;

public interface ICategoryService {
    List<CategoryResponse> getAllCategories();
    CategoryResponse getOneCategory(String categoryId);
    CategoryResponse createCategory(CategoryRequest request);
    CategoryResponse updateCategory(String categoryId,CategoryRequest request);
    void deleteCategory(String[] categoryId);
    Map<String, Map<String, List<Map<String, String>>>> getCategories();
}
