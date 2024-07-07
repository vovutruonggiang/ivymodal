package com.ivymodal.mapper;

import com.ivymodal.dto.Cart.request.CartRequest;
import com.ivymodal.dto.Cart.response.CartResponse;
import com.ivymodal.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mappings({
            @Mapping(target = "productVariant.stock", source = "entity.productVariant.stock")
    })
    CartResponse toCartResponse(Cart entity);

    Cart toCart(CartRequest request);

    List<CartResponse> toCartResponsesList(List<Cart> entities);
}
