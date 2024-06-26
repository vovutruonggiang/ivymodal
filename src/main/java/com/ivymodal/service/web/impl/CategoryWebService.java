package com.ivymodal.service.web.impl;

import com.ivymodal.dto.Category.response.CategoryResponse;
import com.ivymodal.entity.Category;
import com.ivymodal.mapper.CategoryMapper;
import com.ivymodal.repository.CategoryRepository;
import com.ivymodal.service.web.ICategoryWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryWebService implements ICategoryWebService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories1 = categoryRepository.findCategoryByMenuParentId("");
        List<CategoryResponse> categoryResponses = categoryMapper.toCategoryResponseList(categories1);

       for(int i = 0 ; i < categories1.size(); i++){
           Category category = categories1.get(i);
           // Lấy danh sách Category con (category2)
           List<Category> categories2 = categoryRepository.findCategoryByMenuParentId(category.getId());
           List<CategoryResponse> subCategoryResponses = categoryMapper.toCategoryResponseList(categories2);
           // Thiết lập subCategories vào CategoryResponse tương ứng
           categoryResponses.get(i).setSubCategories(subCategoryResponses);

           for (int j = 0; j < categories2.size(); j++) {
               Category category2 = categories2.get(j);

               // Lấy danh sách Category con (category3)
               List<Category> categories3 = categoryRepository.findCategoryByMenuParentId(category2.getId());
               List<CategoryResponse> subCategory2Responses = categoryMapper.toCategoryResponseList(categories3);

               // Thiết lập subCategories của category2 vào CategoryResponse tương ứng
               categoryResponses.get(i).getSubCategories().get(j).setSubCategories(subCategory2Responses);
           }
       }

        return categoryResponses;
    }
}
