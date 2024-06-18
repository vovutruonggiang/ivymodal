package com.ivymodal.mapper;

import com.ivymodal.dto.Product.request.ProductRequest;
import com.ivymodal.dto.Product.response.ProductDiscountActiveResponse;
import com.ivymodal.dto.Product.response.ProductResponse;
import com.ivymodal.dto.Product.response.ProductDiscountWithoutActiveResponse;
import com.ivymodal.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ProductMapper{
   Product toProduct(ProductRequest request);

   ProductResponse toProductResponse(Product product);

   List<ProductDiscountWithoutActiveResponse> toProductDiscountResponseList(List<Product> products);

   void updateProduct(@MappingTarget Product product, ProductRequest request);
}
