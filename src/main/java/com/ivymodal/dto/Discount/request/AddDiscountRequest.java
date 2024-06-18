package com.ivymodal.dto.Discount.request;

import com.ivymodal.dto.Product.request.ProductRequest;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddDiscountRequest {
    List<DiscountRequest> discountRequest;
    List<ProductRequest> productRequest;
}
