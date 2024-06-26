package com.ivymodal.service.web;

import com.ivymodal.dto.Product.response.ProductDto;

import java.util.List;

public interface IProductWebService {
    List<ProductDto> getAllProductWomen();
    List<ProductDto> getAllProductMen();
    List<ProductDto> getAllProductByCategory(String id_Category);
}
