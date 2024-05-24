package com.ivymodal.mapper;

import com.ivymodal.dto.ProductImageDTO;
import com.ivymodal.entity.ProductImageEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductImageMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ProductImageEntity toEntity(ProductImageDTO dto) {
        return modelMapper.map(dto, ProductImageEntity.class);
    }

    public ProductImageDTO toDTO(ProductImageEntity entity) {
        return modelMapper.map(entity, ProductImageDTO.class);
    }
}
