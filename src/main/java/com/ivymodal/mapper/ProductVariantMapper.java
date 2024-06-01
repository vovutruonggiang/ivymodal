package com.ivymodal.mapper;

import com.ivymodal.dto.ProductVariant.request.ProductVariantRequest;
import com.ivymodal.dto.ProductVariant.response.ProductVariantResponse;
import com.ivymodal.entity.ProductVariant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductVariantMapper {
    List<ProductVariant> toProductVariantList(List<ProductVariantRequest> requests);

    List<ProductVariantResponse> toProductVariantResponseList(List<ProductVariant> productVariantList);
}
