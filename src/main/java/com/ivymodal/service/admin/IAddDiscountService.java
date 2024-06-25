package com.ivymodal.service.admin;

import com.ivymodal.dto.Discount.request.AddDiscountRequest;
import com.ivymodal.dto.Discount.response.AddDiscountResponse;

import java.util.List;

public interface IAddDiscountService {
    List<AddDiscountResponse> createDiscount(List<AddDiscountRequest> discountRequest);
    void deleteDiscount(String[] adddiscountId);
}
