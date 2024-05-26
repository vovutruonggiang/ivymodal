package com.ivymodal.service.impl;

import com.ivymodal.dto.CategoryDTO;
import com.ivymodal.entity.CategoryEntity;
import com.ivymodal.mapper.CategoryMapper;
import com.ivymodal.repository.CategoryRepository;
import com.ivymodal.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = categoryMapper.toEntity(categoryDTO);
        categoryEntity = categoryRepository.save(categoryEntity);
        return categoryMapper.toDTO(categoryEntity);
    }

    @Override
    public CategoryDTO updateCategory(int id,CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).get();
        categoryEntity = categoryMapper.toEntity(categoryDTO);
        categoryEntity.setId(id);
        categoryEntity = categoryRepository.save(categoryEntity);
        return categoryMapper.toDTO(categoryEntity);
    }

    @Override
    public void deleteCategory(int[] ids) {
        for(int id : ids) {
            categoryRepository.deleteById(id);
        }
    }
}
