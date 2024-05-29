package com.ivymodal.dto.Product.response;

import com.ivymodal.dto.BaseDTO;
import com.ivymodal.dto.Category.response.CategoryResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse extends BaseDTO {
    String name;
    String description;
    String thumbnail;
    CategoryResponse category;
}
