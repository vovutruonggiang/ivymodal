package com.ivymodal.mapper;

import com.ivymodal.dto.ProductImages.request.ProductImagesRequest;
import com.ivymodal.dto.ProductImages.response.ProductImagesResponse;
import com.ivymodal.entity.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductImageMapper {
    ProductImagesResponse toProductImagesResponse(ProductImage productImages);

    List<ProductImage> toProductImagesList(List<ProductImagesRequest> requests);

    List<ProductImagesResponse> toProductImagesResponseList(List<ProductImage> productImages);

}
