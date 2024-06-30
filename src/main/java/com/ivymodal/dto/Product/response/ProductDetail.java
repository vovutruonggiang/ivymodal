package com.ivymodal.dto.Product.response;

import com.ivymodal.dto.BaseDTO;
import com.ivymodal.dto.Color.response.ColorProductDetailResponse;
import com.ivymodal.dto.Color.response.ColorResponse;
import com.ivymodal.dto.ProductVariant.response.VariantProductDetailResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDetail extends BaseDTO {
    String name;
    String description;
    String thumbnail;
    String id_category;
    private List<VariantProductDetailResponse> productVariants;

}
