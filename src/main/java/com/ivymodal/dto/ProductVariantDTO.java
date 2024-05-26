package com.ivymodal.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ProductVariantDTO extends BaseDTO{
    Double price;
    Boolean status;
    int stock;
    ProductDTO product;
    ColorDTO color;
    SizeDTO size;

}
