package com.ivymodal.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.logging.Level;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class AddDiscountDTO extends BaseDTO{
    ProductDTO product;
    DiscountDTO discount;
}
