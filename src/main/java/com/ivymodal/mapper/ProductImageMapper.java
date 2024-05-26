package com.ivymodal.mapper;

import com.ivymodal.dto.ProductImageDTO;
import com.ivymodal.entity.ProductImageEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductImageMapper extends BaseConversion<ProductImageDTO, ProductImageEntity> {
    public ProductImageMapper() {
        super(ProductImageDTO.class, ProductImageEntity.class);
    }
}
