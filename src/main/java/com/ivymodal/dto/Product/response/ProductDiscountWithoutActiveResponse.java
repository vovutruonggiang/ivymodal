package com.ivymodal.dto.Product.response;

import com.ivymodal.dto.Category.response.CategoryResponse;
import lombok.Data;

@Data
public class ProductDiscountWithoutActiveResponse {
    String name;
    Boolean isPromoted;
    CategoryResponse category;
}
