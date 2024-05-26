package com.ivymodal.mapper;

import com.ivymodal.dto.ProductDTO;
import com.ivymodal.dto.ProductVariantDTO;
import com.ivymodal.entity.ProductEntity;
import com.ivymodal.entity.ProductVariantEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductVariantMapper extends BaseConversion<ProductVariantDTO, ProductVariantEntity> {
   public ProductVariantMapper() {
       super(ProductVariantDTO.class, ProductVariantEntity.class);
   }
}
