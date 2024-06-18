package com.ivymodal.mapper;

import com.ivymodal.dto.Discount.request.AddDiscountRequest;
import com.ivymodal.dto.Discount.response.AddDiscountResponse;
import com.ivymodal.entity.AddDiscount;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddDiscountMapper {
    List<AddDiscount> toAddDiscounts(List<AddDiscountRequest> requests);
    List<AddDiscountResponse> toAddDiscountResponses(List<AddDiscount> addDiscounts);

    void updateAddDiscount(@MappingTarget List<AddDiscount> addDiscount,List<AddDiscountRequest> requests);
}
