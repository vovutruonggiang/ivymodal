package com.ivymodal.dto.ProductVariant.request;

import com.ivymodal.dto.Color.response.ColorResponse;
import com.ivymodal.dto.Product.response.ProductResponse;
import com.ivymodal.dto.Size.response.SizeResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductVariantRequest {
    ProductResponse product;
    ColorResponse color;
    SizeResponse size;
    Double price;
    Boolean status;
    int stock;
}
