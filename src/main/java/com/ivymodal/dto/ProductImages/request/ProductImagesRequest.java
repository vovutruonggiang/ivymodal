package com.ivymodal.dto.ProductImages.request;

import com.ivymodal.dto.Color.response.ColorResponse;
import com.ivymodal.dto.Product.response.ProductResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductImagesRequest {
    ProductResponse product;
    ColorResponse color;
    String image_url;
}
