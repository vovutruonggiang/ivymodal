package com.ivymodal.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ProductWithVariantsDTO {
    private ProductDTO productDTO;
    private List<ProductVariantDTO> productVariantDTOList;
    private List<ProductImageDTO> productImageDTOList;
}
