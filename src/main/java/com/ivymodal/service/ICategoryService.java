package com.ivymodal.service;

import com.ivymodal.dto.CategoryDTO;

public interface ICategoryService {
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(int id,CategoryDTO categoryDTO);
    void deleteCategory(int[] ids);
}
