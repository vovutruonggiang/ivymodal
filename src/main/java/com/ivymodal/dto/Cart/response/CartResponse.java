package com.ivymodal.dto.Cart.response;

import com.ivymodal.dto.BaseDTO;
import com.ivymodal.dto.Product.response.ProductCartResponse;
import com.ivymodal.dto.Product.response.ProductResponse;
import com.ivymodal.dto.ProductVariant.response.ProductVariantResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartResponse extends BaseDTO {
    String idUser;
    ProductCartResponse product;
    ProductVariantResponse productVariant;
    int quantity;
}
