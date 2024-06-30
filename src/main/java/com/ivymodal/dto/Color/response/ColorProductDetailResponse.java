package com.ivymodal.dto.Color.response;

import com.ivymodal.dto.BaseDTO;
import com.ivymodal.dto.ProductVariant.response.VariantDto;
import com.ivymodal.dto.ProductVariant.response.VariantProductDetailResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ColorProductDetailResponse extends BaseDTO {
    String name;
    List<VariantProductDetailResponse> variantProductDetailResponses;

}
