package com.ivymodal.service.admin;

import com.ivymodal.dto.Product.request.ProductRequest;
import com.ivymodal.dto.Product.response.ProductDiscountActiveResponse;
import com.ivymodal.dto.Product.response.ProductDiscountWithoutActiveResponse;
import com.ivymodal.dto.Product.response.ProductResponse;

import java.util.List;

public interface IProductService {
    ProductResponse createProduct(ProductRequest request);
    ProductResponse updateProduct(String productId,ProductRequest request);
    List<ProductResponse> getAllProduct();
    List<ProductResponse> getOneProduct(String productId);
    void DeleteVariant(String[] imagesIds,String[] variantIds);
    void DeleteProduct(String[] productIds);
    List<ProductDiscountWithoutActiveResponse> getAllProductWithoutActiveDiscount();
    List<ProductDiscountActiveResponse> getAllProductActiveDiscount();
}
