package com.ivymodal.mapper;

import com.ivymodal.dto.BannerDTO;
import com.ivymodal.dto.ProductDTO;
import com.ivymodal.entity.BannerEntity;
import com.ivymodal.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper extends BaseConversion<ProductDTO, ProductEntity> {
    public ProductMapper() {
        super(ProductDTO.class, ProductEntity.class);
    }
}
