package com.ivymodal.mapper;

import com.ivymodal.dto.Cart.request.CartRequest;
import com.ivymodal.dto.Cart.response.CartResponse;
import com.ivymodal.entity.Cart;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper (componentModel = "spring")
public interface CartMapper {
    Cart toCart (CartRequest request);

    CartResponse toCartResponses (Cart cart);

}
