package com.ivymodal.mapper;

import com.ivymodal.dto.BannerDTO;
import com.ivymodal.dto.CategoryDTO;
import com.ivymodal.entity.BannerEntity;
import com.ivymodal.entity.CategoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper extends BaseConversion<CategoryDTO, CategoryEntity> {
    public CategoryMapper() {
        super(CategoryDTO.class, CategoryEntity.class);
    }

}
