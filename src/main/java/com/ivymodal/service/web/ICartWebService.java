package com.ivymodal.service.web;

import com.ivymodal.dto.Cart.request.CartRequest;
import com.ivymodal.dto.Cart.response.CartResponse;

public interface ICartWebService {
    CartResponse createCart(CartRequest request);
}
