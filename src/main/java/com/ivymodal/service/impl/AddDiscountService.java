package com.ivymodal.service.impl;

import com.ivymodal.dto.Discount.request.AddDiscountRequest;
import com.ivymodal.dto.Discount.response.AddDiscountResponse;
import com.ivymodal.mapper.AddDiscountMapper;
import com.ivymodal.repository.AddDiscountRepository;
import com.ivymodal.service.IAddDiscountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AddDiscountService implements IAddDiscountService {

    AddDiscountRepository addDiscountRepository;
    AddDiscountMapper addDiscountMapper;

    @Override
    public List<AddDiscountResponse> createDiscount(List<AddDiscountRequest> requests) {

        return null;
    }

    @Override
    public void deleteDiscount(String[] adddiscountId) {

    }

}
