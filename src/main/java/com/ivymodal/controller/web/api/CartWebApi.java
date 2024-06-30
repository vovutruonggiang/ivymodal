package com.ivymodal.controller.web.api;

import com.ivymodal.dto.ApiResponse;
import com.ivymodal.dto.Cart.request.CartRequest;
import com.ivymodal.dto.Cart.response.CartResponse;
import com.ivymodal.service.web.ICartWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-web-cart")
public class CartWebApi {
    @Autowired
    private ICartWebService cartWebService;

    @PostMapping
    public ApiResponse<CartResponse> createCart(@RequestBody CartRequest request) {
        ApiResponse<CartResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(cartWebService.createCart(request));
        return apiResponse;
    }
}
