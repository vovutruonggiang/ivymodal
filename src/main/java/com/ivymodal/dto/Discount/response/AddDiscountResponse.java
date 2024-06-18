package com.ivymodal.dto.Discount.response;

import com.ivymodal.dto.BaseDTO;
import com.ivymodal.dto.Product.response.ProductResponse;
import com.ivymodal.entity.Discount;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddDiscountResponse extends BaseDTO {
    List<DiscountResponse> discounts;
    List<ProductResponse> products;
}
