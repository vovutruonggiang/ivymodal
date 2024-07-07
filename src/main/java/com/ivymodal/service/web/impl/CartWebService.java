package com.ivymodal.service.web.impl;

import com.ivymodal.dto.Cart.request.CartRequest;
import com.ivymodal.dto.Cart.response.CartResponse;
import com.ivymodal.entity.Cart;
import com.ivymodal.entity.Product;
import com.ivymodal.entity.ProductVariant;
import com.ivymodal.entity.Users;
import com.ivymodal.exception.AppException;
import com.ivymodal.exception.ErrorCode;
import com.ivymodal.mapper.CartMapper;
import com.ivymodal.repository.CartRepository;
import com.ivymodal.repository.ProductRepository;
import com.ivymodal.repository.ProductVariantRepository;
import com.ivymodal.repository.UsersRepository;
import com.ivymodal.service.web.ICartWebService;
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
        Users user = usersRepository.findById(request.getIdUser())
                .orElseThrow(() ->new AppException(ErrorCode.USER_NOT_EXISTED));

        Product product = productRepository.findById(request.getIdProduct())
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));

        ProductVariant productVariant = productVariantRepository.findById(request.getIdProductVariant())
                .orElseThrow(()-> new AppException(ErrorCode.VARIANT_NOT_FOUND));


        Cart cartExist = cartRepository.findCartByIdUserAndProductAndVariant(user.getId(),product.getId(),productVariant.getId());

        Cart cart = new Cart();
        if(cartExist != null){
            cartExist.setQuantity(request.getQuantity()+cartExist.getQuantity());
            cart = cartRepository.save(cartExist);
        }else{
            cart.setUsers(user);
            cart.setProduct(product);
            cart.setProductVariant(productVariant);
            cart.setQuantity(request.getQuantity());
            cart = cartRepository.save(cart);
        }

        CartResponse cartResponse = cartMapper.toCartResponse(cart);
        return cartResponse;
    }


//    @Override
//    public CartResponse createCart(CartRequest request) {
//        // Tìm đối tượng Users từ idUser trong request
//        Users user = usersRepository.findById(request.getIdUser())
//                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy người dùng với id: " + request.getIdUser()));
//
//        // Tìm đối tượng Product từ idProduct trong request
//        Product product = productRepository.findById(request.getIdProduct())
//                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy sản phẩm với id: " + request.getIdProduct()));
//
//        // Tìm đối tượng ProductVariant từ idProductVariant trong request
//        ProductVariant productVariant = productVariantRepository.findById(request.getIdProductVariant())
//                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy biến thể sản phẩm với id: " + request.getIdProductVariant()));
//
//        // Kiểm tra số lượng hiện tại trong giỏ hàng cho biến thể sản phẩm này
//        Integer currentCartQuantity = cartRepository.quantityByProductVariant(request.getIdProductVariant());
//
//        ProductVariant stockVariant = productVariantRepository.findById(request.getIdProductVariant())
//                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy biến thể sản phẩm với id: " + request.getIdProductVariant()));
//
//        // Kiểm tra số lượng trong giỏ hàng và số lượng tồn kho
//        if (currentCartQuantity == null) {
//            currentCartQuantity = 0; // Nếu chưa có trong giỏ hàng, set mặc định là 0
//        }
//
//        int quantityToAdd = request.getQuantity(); // Số lượng cần thêm vào giỏ hàng
//
//        // Tính toán số lượng có thể được thêm vào giỏ hàng mà không vượt quá số lượng tồn kho
//        int remainingStock = stockVariant.getStock() - currentCartQuantity;
//        quantityToAdd = Math.min(quantityToAdd, remainingStock);
//
//        // Nếu số lượng có thể thêm vào giỏ hàng lớn hơn 0
//        if (quantityToAdd > 0) {
//            Cart cart = cartMapper.toCart(request);
//            cart.setUsers(user);
//            cart.setProduct(product);
//            cart.setProductVariant(productVariant);
//            `cart`.setQuantity(quantityToAdd);
//
//            // Lưu vào cơ sở dữ liệu và trả về response
//            Cart savedCart = cartRepository.save(cart);
//            return cartMapper.toCartResponse(savedCart);
//        } else {
//            // Nếu không thể thêm số lượng vào giỏ hàng do vượt quá số lượng tồn kho
//            return null; // Hoặc xử lý thông báo lỗi khác tùy vào yêu cầu của bạn
//        }
//    }



}
