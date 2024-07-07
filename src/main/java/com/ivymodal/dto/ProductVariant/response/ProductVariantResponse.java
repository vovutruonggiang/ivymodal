package com.ivymodal.dto.ProductVariant.response;

import com.ivymodal.dto.BaseDTO;
import com.ivymodal.dto.Color.response.ColorResponse;
import com.ivymodal.dto.Size.response.SizeResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductVariantResponse extends BaseDTO {
    ColorResponse color;
    SizeResponse size;
    Double price;
    Boolean status;
    int stock;
}
