package com.ivymodal.mapper;

import com.ivymodal.dto.Category.request.CategoryRequest;
import com.ivymodal.dto.Category.response.CategoryResponse;
import com.ivymodal.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
   Category toCategory(CategoryRequest request);

   CategoryResponse toCategoryResponse(Category category);

   void updateCategory(@MappingTarget Category category, CategoryRequest request);
}
