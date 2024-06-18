package com.ivymodal.dto.Product.response;

import com.ivymodal.dto.BaseDTO;
import com.ivymodal.dto.Category.response.CategoryResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDiscountActiveResponse{
    String name;
    Boolean isPromoted;
    String categoryId; // Sử dụng String thay vì CategoryResponse để khớp với tên category
    Float discountValue;
    String discountType;

    public ProductDiscountActiveResponse(String name, Boolean isPromoted, String categoryId, Float discountValue, String discountType) {
        this.name = name;
        this.isPromoted = isPromoted;
        this.categoryId = categoryId;
        this.discountValue = discountValue;
        this.discountType = discountType;
    }
}
