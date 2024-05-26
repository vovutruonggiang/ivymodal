package com.ivymodal.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ProductImageDTO extends BaseDTO{
    ProductDTO product;
    ColorDTO colorDTO;
    String image_url;

}
