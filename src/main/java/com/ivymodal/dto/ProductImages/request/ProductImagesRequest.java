package com.ivymodal.dto.ProductImages.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductImagesRequest {
    String id_product;
    String id_color;
    String image_url;
}
