package com.ivymodal.service;

import com.ivymodal.dto.Discount.request.AddDiscountRequest;
import com.ivymodal.dto.Discount.request.DiscountRequest;
import com.ivymodal.dto.Discount.response.AddDiscountResponse;
import com.ivymodal.dto.Discount.response.DiscountResponse;

import java.util.List;

public interface IAddDiscountService {
    List<AddDiscountResponse> createDiscount(List<AddDiscountRequest> discountRequest);
    void deleteDiscount(String[] adddiscountId);
}
