package com.ivymodal.service.impl;

import com.ivymodal.dto.Discount.request.DiscountRequest;
import com.ivymodal.dto.Discount.response.DiscountResponse;
import com.ivymodal.entity.Discount;
import com.ivymodal.exception.AppException;
import com.ivymodal.exception.ErrorCode;
import com.ivymodal.mapper.DiscountMapper;
import com.ivymodal.repository.DiscountRepository;
import com.ivymodal.service.IDiscountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DiscountService implements IDiscountService {

    DiscountRepository discountRepository;
    DiscountMapper discountMapper;

    @Override
    public DiscountResponse createDiscount(DiscountRequest request) {
        if(discountRepository.existsByName(request.getName())){
            throw new AppException(ErrorCode.DISCOUNT_EXISTED);
        }
        return discountMapper.toDiscountResponse(discountRepository.save(discountMapper.toDiscount(request)));
    }

    @Override
    public DiscountResponse updateDiscount(String discountId, DiscountRequest request) {
        Discount discount = discountRepository.findById(discountId)
                .orElseThrow(() -> new AppException(ErrorCode.DISCOUNT_NOT_FOUND));
        discountMapper.updateDiscount(discount,request);
        return discountMapper.toDiscountResponse(discountRepository.save(discount));
    }

    @Override
    public void deleteDiscount(String[] discountIds) {
        for(String discount : discountIds){
            discountRepository.deleteById(discount);
        }
    }

    @Override
    public List<DiscountResponse> getAllDiscounts() {
        return discountMapper.toDiscountResponsesList(discountRepository.findAll());
    }

    @Override
    public DiscountResponse getOneDiscount(String discountId) {
        Discount discount = discountRepository.findById(discountId)
                .orElseThrow(() -> new AppException(ErrorCode.DISCOUNT_NOT_FOUND));
        return discountMapper.toDiscountResponse(discount);
    }
}
