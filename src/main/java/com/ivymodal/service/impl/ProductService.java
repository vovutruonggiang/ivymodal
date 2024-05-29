package com.ivymodal.service.impl;

import com.ivymodal.dto.ProductVariantImages.request.ProductVariantImagesRequest;
import com.ivymodal.dto.ProductVariantImages.response.ProductVariantImagesResponse;
import com.ivymodal.entity.Product;
import com.ivymodal.entity.ProductVariant;
import com.ivymodal.exception.AppException;
import com.ivymodal.exception.ErrorCode;
import com.ivymodal.mapper.ProductMapper;
import com.ivymodal.mapper.ProductVariantMapper;
import com.ivymodal.repository.ProductRepository;
import com.ivymodal.repository.ProductVariantRepository;
import com.ivymodal.service.IProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//@RequiredArgsConstructor
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductVariantRepository productVariantRepository;

    @Autowired
    private ProductVariantMapper productVariantMapper;

    @Override
    public ProductVariantImagesResponse createProduct(ProductVariantImagesRequest request) {
//        saveProduct(request);
        saveVariant(request);
        return null;
    }

    public void saveProduct(ProductVariantImagesRequest request) {
        if(productRepository.existsByName(request.getProduct().getName()))
            throw new AppException(ErrorCode.PRODUCT_EXISTED);
        Product product = productMapper.toProduct(request.getProduct());
        productRepository.save(product);
    }

    public List<ProductVariantImagesResponse> saveVariant(ProductVariantImagesRequest request) {
        List<ProductVariant> productVariants = productVariantMapper.toProductVariantList(request.getProductVariant());
        productVariantRepository.saveAll(productVariants);
        return null;
    }
}
