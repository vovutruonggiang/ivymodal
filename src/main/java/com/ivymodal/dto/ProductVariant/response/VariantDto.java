package com.ivymodal.dto.ProductVariant.response;

import com.ivymodal.dto.BaseDTO;
import com.ivymodal.dto.Color.response.ColorResponse;
import com.ivymodal.dto.Size.response.SizeResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VariantDto extends BaseDTO {
    String color;
    List<String> size;
    Double price;
    Boolean status;
    int stock;
}
