package com.ivymodal.service;

import com.ivymodal.dto.ProductWithVariantsDTO;

public interface IProductService {
    ProductWithVariantsDTO saveProduct(int id,ProductWithVariantsDTO productWithVariantsDTO,boolean isUpdate);
    ProductWithVariantsDTO createProduct(int id,ProductWithVariantsDTO productWithVariantsDTO);
    ProductWithVariantsDTO updateProduct(int id, ProductWithVariantsDTO productWithVariantsDTO);
}
