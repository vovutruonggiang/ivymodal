package com.ivymodal.dto.ProductImages.response;

import com.ivymodal.dto.BaseDTO;
import com.ivymodal.dto.Color.response.ColorResponse;
import com.ivymodal.dto.Product.response.ProductResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductImagesResponse extends BaseDTO {
    ColorResponse color;
    String image_url;
}
