package com.ivymodal.dto.Product.response;

import com.ivymodal.dto.BaseDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCartResponse extends BaseDTO {
    String name;
}
