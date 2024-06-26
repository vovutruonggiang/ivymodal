package com.ivymodal.dto.Product.response;

import com.ivymodal.dto.BaseDTO;
import com.ivymodal.dto.ProductImages.response.ProductImagesResponse;
import com.ivymodal.dto.ProductVariant.response.VariantDto;
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
    List<VariantDto> productVariants;
    List<ProductImagesResponse> productImages;
}
