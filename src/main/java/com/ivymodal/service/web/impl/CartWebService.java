package com.ivymodal.service.web.impl;

import com.ivymodal.dto.Cart.request.CartRequest;
import com.ivymodal.dto.Cart.response.CartResponse;
import com.ivymodal.entity.Cart;
import com.ivymodal.entity.Product;
import com.ivymodal.entity.ProductVariant;
import com.ivymodal.entity.Users;
import com.ivymodal.mapper.CartMapper;
import com.ivymodal.repository.CartRepository;
import com.ivymodal.repository.ProductRepository;
import com.ivymodal.repository.ProductVariantRepository;
import com.ivymodal.repository.UsersRepository;
import com.ivymodal.service.web.ICartWebService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartWebService implements ICartWebService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductVariantRepository productVariantRepository;


    @Override
    public CartResponse createCart(CartRequest request) {
        // Tìm đối tượng Users từ idUser trong request
        Users user = usersRepository.findById(request.getIdUser())
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy người dùng với id: " + request.getIdUser()));

        // Tìm đối tượng Product từ idProduct trong request
        Product product = productRepository.findById(request.getIdProduct())
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy sản phẩm với id: " + request.getIdProduct()));

        // Tìm đối tượng ProductVariant từ idProductVariant trong request
        ProductVariant productVariant = productVariantRepository.findById(request.getIdProductVariant())
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy biến thể sản phẩm với id: " + request.getIdProductVariant()));

        // Tạo đối tượng Cart từ request và các đối tượng đã tìm được
        Cart cart = cartMapper.toCart(request);
        cart.setUsers(user);
        cart.setProduct(product);
        cart.setProductVariant(productVariant);

        // Lưu cart vào cơ sở dữ liệu và trả về response
        return cartMapper.toCartResponses(cartRepository.save(cart));
    }
}
