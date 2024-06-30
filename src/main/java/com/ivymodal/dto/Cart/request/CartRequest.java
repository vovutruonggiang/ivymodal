package com.ivymodal.dto.Cart.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartRequest {
    String idUser;
    String idProduct;
    String idProductVariant;
    int quantity;
}
