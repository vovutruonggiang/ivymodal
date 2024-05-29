package com.ivymodal.mapper;

import com.ivymodal.dto.Product.request.ProductRequest;
import com.ivymodal.dto.Product.response.ProductResponse;
import com.ivymodal.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface ProductMapper{
   Product toProduct(ProductRequest request);

   ProductResponse toProductResponse(Product product);

   void updateProduct(@MappingTarget Product product, ProductRequest request);
}
