package com.ivymodal.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ProductDTO extends BaseDTO {
    String name;
    String description;
    String thumbnail;
    List<ProductVariantDTO> productVariantDTO;
    CategoryDTO categoryDTO;
    List<ProductImageDTO> productImageDTO;
}
