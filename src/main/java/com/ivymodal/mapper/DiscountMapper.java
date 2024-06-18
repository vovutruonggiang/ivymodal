package com.ivymodal.mapper;

import com.ivymodal.dto.Discount.request.DiscountRequest;
import com.ivymodal.dto.Discount.response.DiscountResponse;
import com.ivymodal.entity.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiscountMapper {
    Discount toDiscount(DiscountRequest request);

    DiscountResponse toDiscountResponse(Discount discount);

    List<DiscountResponse> toDiscountResponsesList(List<Discount> discounts);

    void updateDiscount(@MappingTarget Discount discount, DiscountRequest request);
}
