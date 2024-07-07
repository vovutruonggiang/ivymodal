package com.ivymodal.service.admin.web.impl;

import com.ivymodal.dto.Cart.response.CartResponse;
import com.ivymodal.entity.Cart;
import com.ivymodal.mapper.CartMapper;
import com.ivymodal.repository.CartRepository;
import com.ivymodal.service.web.IPayWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PayWebService implements IPayWebService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<CartResponse> getAllCartByUserId(String idUser) {
        List<Cart> carts = cartRepository.findByCustomerId(idUser);

        Map<String,Cart> groupedCarts  = new HashMap<>();
        for(Cart cart : carts){
            String key = cart.getProduct().getId() + "-" + cart.getProductVariant().getId();
            if(groupedCarts.containsKey(key)){
                Cart existingCart = groupedCarts.get(key);
                existingCart.setQuantity(existingCart.getQuantity() + cart.getQuantity());
            }else {
                groupedCarts.put(key,cart);
            }
        }

         List<CartResponse> cartResponses = groupedCarts.values().stream()
                .map(cartMapper::toCartResponse)
                .collect(Collectors.toList());

        return cartResponses;
    }


}
