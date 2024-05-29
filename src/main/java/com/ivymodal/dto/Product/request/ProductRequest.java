package com.ivymodal.dto.Product.request;

import com.ivymodal.dto.Category.response.CategoryResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {
    String name;
    String description;
    String thumbnail;
    CategoryResponse category;
}
