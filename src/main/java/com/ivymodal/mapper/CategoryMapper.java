package com.ivymodal.mapper;

import com.ivymodal.dto.BannerDTO;
import com.ivymodal.dto.CategoryDTO;
import com.ivymodal.entity.BannerEntity;
import com.ivymodal.entity.CategoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    @Autowired
    private ModelMapper modelMapper;

    public CategoryDTO toDTO(CategoryEntity categoryEntity) {
        return modelMapper.map(categoryEntity, CategoryDTO.class);
    }

    public CategoryEntity toEntity(CategoryDTO dto) {
        return modelMapper.map(dto, CategoryEntity.class);
    }

}
