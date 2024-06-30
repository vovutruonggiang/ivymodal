package com.ivymodal.dto.ProductVariant.response;

import com.ivymodal.dto.Size.response.SizeProductDetailResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VariantProductDetailResponse {
    String id;
    String color;
    List<SizeProductDetailResponse> size;
    String image_url;
}
