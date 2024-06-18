package com.ivymodal.service;

import com.ivymodal.dto.Discount.request.DiscountRequest;
import com.ivymodal.dto.Discount.response.DiscountResponse;

import java.util.List;

public interface IDiscountService {
    DiscountResponse createDiscount(DiscountRequest request);
    DiscountResponse updateDiscount(String discountId,DiscountRequest request);
    void deleteDiscount(String[] discountId);
    List<DiscountResponse> getAllDiscounts();
    DiscountResponse getOneDiscount(String discountIds);
}
