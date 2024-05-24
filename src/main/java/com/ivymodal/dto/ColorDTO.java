package com.ivymodal.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ColorDTO extends BaseDTO{
    String name;
    String color_coding;
    List<ProductVariantDTO> productVariantDTO;
    List<ProductImageDTO> productImageDTO;
}
