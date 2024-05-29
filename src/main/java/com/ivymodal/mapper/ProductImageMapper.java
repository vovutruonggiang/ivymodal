package com.ivymodal.mapper;

import com.ivymodal.dto.ProductImages.request.ProductImagesRequest;
import com.ivymodal.dto.ProductImages.response.ProductImagesResponse;
import com.ivymodal.entity.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductImageMapper {
    ProductImage toProductImage(ProductImagesRequest request);

    ProductImagesResponse toProductImagesResponse(ProductImagesResponse response);

    void updateProductImage(@MappingTarget ProductImage productImage,ProductImagesRequest request);
}
