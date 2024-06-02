package com.ivymodal.dto.Product.request;

import lombok.Data;

@Data
public class ProductDeleteRequest {
    private String[] productIds;
    private String[] variantIds;
    private String[] imagesIds;
}
