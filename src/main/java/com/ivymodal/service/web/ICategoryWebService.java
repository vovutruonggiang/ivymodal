package com.ivymodal.service.web;

import com.ivymodal.dto.Category.response.CategoryResponse;

import java.util.List;

public interface ICategoryWebService {
    List<CategoryResponse> getAllCategories();
}
