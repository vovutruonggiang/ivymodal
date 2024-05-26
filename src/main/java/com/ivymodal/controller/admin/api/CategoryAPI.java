package com.ivymodal.controller.admin.api;

import com.ivymodal.dto.CategoryDTO;
import com.ivymodal.entity.CategoryEntity;
import com.ivymodal.mapper.CategoryMapper;
import com.ivymodal.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-admin-category")
public class CategoryAPI {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public CategoryDTO createCategory(@RequestBody CategoryDTO category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public CategoryDTO updateCategory(@PathVariable int id, @RequestBody CategoryDTO category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/delete")
    public void deleteCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.deleteCategory(categoryDTO.getIds());
    }
}
