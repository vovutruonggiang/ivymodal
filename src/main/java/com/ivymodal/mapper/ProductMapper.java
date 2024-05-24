package com.ivymodal.mapper;

import com.ivymodal.dto.BannerDTO;
import com.ivymodal.dto.ProductDTO;
import com.ivymodal.entity.BannerEntity;
import com.ivymodal.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ProductDTO toDTO(ProductEntity product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    public ProductEntity toEntity(ProductDTO dto) {
        return modelMapper.map(dto, ProductEntity.class);
    }

}
