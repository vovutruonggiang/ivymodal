package com.ivymodal.service.web;

import com.ivymodal.dto.Product.response.ProductDetail;

import java.util.List;

public interface IProductDetailService {
    ProductDetail getAllProductDetail(String idProduct);
}
