package com.ivymodal.service.web;

import com.ivymodal.dto.Cart.response.CartResponse;
import com.ivymodal.entity.Cart;

import java.util.List;

public interface IPayWebService {
    List<CartResponse> getAllCartByUserId(String idUser);

}
