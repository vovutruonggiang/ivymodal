package com.ivymodal.controller.web.api;

import com.ivymodal.dto.ApiResponse;
import com.ivymodal.dto.Cart.response.CartResponse;
import com.ivymodal.service.web.IPayWebService;
import com.ivymodal.service.web.IPayWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-web-pay")
public class PayWebAPI {
    @Autowired
    private IPayWebService payWebService;

    @GetMapping("/{idUser}")
    public ApiResponse<List<CartResponse>> getAllCartByIdUser(@PathVariable  String idUser) {
        ApiResponse<List<CartResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(payWebService.getAllCartByUserId(idUser));
        return apiResponse;
    }
}
