package com.ivymodal.service;

import com.ivymodal.dto.ProductWithVariantsDTO;

public interface IProductService {
    ProductWithVariantsDTO createProduct(ProductWithVariantsDTO productWithVariantsDTO);
    ProductWithVariantsDTO updateProduct(int id, ProductWithVariantsDTO productWithVariantsDTO);
    void deleteProduct(int id);
}
