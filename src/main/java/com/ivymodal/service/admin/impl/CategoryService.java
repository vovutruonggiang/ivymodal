package com.ivymodal.service.admin.impl;

import com.ivymodal.dto.Category.request.CategoryRequest;
import com.ivymodal.dto.Category.response.CategoryResponse;
import com.ivymodal.entity.Category;
import com.ivymodal.exception.AppException;
import com.ivymodal.exception.ErrorCode;
import com.ivymodal.mapper.CategoryMapper;
import com.ivymodal.repository.CategoryRepository;
import com.ivymodal.service.admin.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper::toCategoryResponse).collect(Collectors.toList());
    }

    @Override
    public CategoryResponse getOneCategory(String categoryId) {
        return categoryMapper.toCategoryResponse(
                categoryRepository.findById(categoryId).orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND)));
    }

    @Override
    public CategoryResponse createCategory(CategoryRequest request) {
//        if (categoryRepository.existsByName(request.getName()))
//            throw new AppException(ErrorCode.CATEGORY_EXISTED);

        Category category = categoryMapper.toCategory(request);

        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }

    @Override
    public CategoryResponse updateCategory(String categoryId, CategoryRequest request) {
        Category category = categoryRepository.findById(categoryId)
                        .orElseThrow(()-> new AppException(ErrorCode.CATEGORY_NOT_FOUND));
        categoryMapper.updateCategory(category,request);
        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }

    @Override
    public void deleteCategory(String[] categoryId) {
        for (String category : categoryId) {
            categoryRepository.deleteById(category);
        }
    }

    @Override
    public Map<String, Map<String, List<Map<String, String>>>> getCategories() {
        Map<String, Map<String, List<Map<String, String>>>> result = new HashMap<>();

        // Lấy danh mục cấp 1
        List<Category> rootCategories = categoryRepository.findByMenuParentId("");
        for (Category rootCategory : rootCategories) {
            Map<String, List<Map<String, String>>> subCategoriesMap = new HashMap<>();

            // Lấy danh mục cấp 2
            List<Category> subCategories = categoryRepository.findByMenuParentId(rootCategory.getId());
            for (Category subCategory : subCategories) {
                // Lấy danh mục cấp 3
                List<Category> items = categoryRepository.findByMenuParentId(subCategory.getId());
                List<Map<String, String>> itemList = items.stream()
                        .map(item -> {
                            Map<String, String> itemMap = new HashMap<>();
                            itemMap.put("id", item.getId());
                            itemMap.put("name", item.getName());
                            return itemMap;
                        })
                        .collect(Collectors.toList());
                subCategoriesMap.put(subCategory.getMenu_link(), itemList);
            }

            result.put(rootCategory.getMenu_link(), subCategoriesMap);
        }

        return result;
    }
}
