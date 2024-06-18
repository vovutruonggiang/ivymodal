package com.ivymodal.service.impl;

import com.ivymodal.dto.Category.response.CategoryResponse;
import com.ivymodal.dto.Product.request.ProductRequest;
import com.ivymodal.dto.Product.response.ProductDiscountActiveResponse;
import com.ivymodal.dto.Product.response.ProductResponse;
import com.ivymodal.dto.Product.response.ProductDiscountWithoutActiveResponse;
import com.ivymodal.dto.ProductImages.response.ProductImagesResponse;
import com.ivymodal.dto.ProductVariant.response.ProductVariantResponse;
import com.ivymodal.entity.Product;
import com.ivymodal.entity.ProductImage;
import com.ivymodal.entity.ProductVariant;
import com.ivymodal.exception.AppException;
import com.ivymodal.exception.ErrorCode;
import com.ivymodal.mapper.*;
import com.ivymodal.repository.ProductImageRepository;
import com.ivymodal.repository.ProductRepository;
import com.ivymodal.repository.ProductVariantRepository;
import com.ivymodal.service.IProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class ProductService implements IProductService {
    ProductRepository productRepository;
    ProductMapper productMapper;
    ProductVariantRepository productVariantRepository;
    ProductVariantMapper productVariantMapper;
    ProductImageRepository productImageRepository;
    ProductImageMapper productImageMapper;
    CategoryMapper categoryMapper;

    @Override
    public List<ProductDiscountWithoutActiveResponse> getAllProductWithoutActiveDiscount() {
        List<Product> products = productRepository.findByIsPromotedWithoutActiveDiscount();
        return productMapper.toProductDiscountResponseList(products);
    }

    @Override
    public List<ProductDiscountActiveResponse> getAllProductActiveDiscount() {
        return productRepository.findPromotedProducts();
    }


    @Override
    @Transactional
    public ProductResponse createProduct(ProductRequest request) {
        if (productRepository.existsByName(request.getName())){
            throw new AppException(ErrorCode.PRODUCT_EXISTED);
        }

        Product product = productMapper.toProduct(request);
        Product savedProduct = productRepository.save(product);

        List<ProductVariant> productVariants = productVariantMapper.toProductVariantList(request.getProductVariants());
        productVariants.forEach(variant -> variant.setProduct(savedProduct));
        productVariantRepository.saveAll(productVariants);

        List<ProductImage> productImages = productImageMapper.toProductImagesList(request.getProductImages());
        for (int i = 0; i < productImages.size(); i++) {
            ProductImage productImage = productImages.get(i);
            productImage.setProduct(product);
        }
        productImageRepository.saveAll(productImages);
        return buildProductResponse(product, productVariants, productImages);
    }

    @Override
    @Transactional
    public ProductResponse updateProduct(String productId, ProductRequest request) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        productMapper.updateProduct(product, request);
        Product saveProduct = productRepository.save(product);

        List<ProductVariant> productVariantOld = productVariantRepository.findByProductId(productId);

        List<ProductVariant> productVariants = productVariantMapper.toProductVariantList(request.getProductVariants());
        for (int i = 0; i < productVariants.size(); i++) {
            if (i < productVariantOld.size()) {
                productVariants.get(i).setId(productVariantOld.get(i).getId());
                productVariants.get(i).setProduct(product);
            }else{
                productVariants.forEach(variant -> variant.setProduct(saveProduct));
            }
        }
        productVariantRepository.saveAll(productVariants);

        List<ProductImage> productImageOld = productImageRepository.findByProductId(productId);

        List<ProductImage> productImages = productImageMapper.toProductImagesList(request.getProductImages());
        for (int i = 0; i < productImages.size(); i++) {
            if (i < productImageOld.size()) {
                productImages.get(i).setColor(productImageOld.get(i).getColor());
                productImages.get(i).setId(productImageOld.get(i).getId());
                productImages.get(i).setProduct(product);
            }else{
                productImages.forEach(variant -> variant.setProduct(saveProduct));
                productVariantRepository.saveAll(productVariants);
            }
        }
        productImageRepository.saveAll(productImages);
        return buildProductResponse(product, productVariants, productImages);
    }

    @Override
    public List<ProductResponse> getAllProduct() {
       return productRepository.findAll()
               .stream()
               .map(product -> {
                   List<ProductVariant> productVariants = productVariantRepository.findByProductId(product.getId());
                   List<ProductImage> productImages = productImageRepository.findByProductId(product.getId());
                   return buildProductResponse(product, productVariants, productImages);
               })
               .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> getOneProduct(String productId) {
        return productRepository.findById(productId)
                .stream()
                .map(product -> {
                    List<ProductVariant> productVariants = productVariantRepository.findByProductId(product.getId());
                    List<ProductImage> productImages = productImageRepository.findByProductId(product.getId());
                    return buildProductResponse(product, productVariants, productImages);
                }).collect(Collectors.toList());
    }

    @Override
    public void DeleteVariant(String[] imagesIds,String[] variantIds) {
        DeleteVariantWithImages(imagesIds, variantIds);
    }

    @Override
    public void DeleteProduct(String[] productIds) {
        for(String productId : productIds){
            List<ProductImage> productImage = productImageRepository.findByProductId(productId);
            if(productImage != null) {
                productImageRepository.deleteAll(productImage);
            }

            List<ProductVariant> productVariants = productVariantRepository.findByProductId(productId);
            if(productVariants != null) {
                productVariantRepository.deleteAll(productVariants);
            }

            productRepository.deleteById(productId);
        }
    }

    private void DeleteVariantWithImages(String[] imagesIds,String[] variantIds){
        for(String imagesId : imagesIds){
            productImageRepository.deleteById(imagesId);
        }
        for (String variantId : variantIds) {
            productVariantRepository.deleteById(variantId);
        }
    }

    private ProductResponse buildProductResponse(Product product, List<ProductVariant> variants, List<ProductImage> images) {
        ProductResponse productResponse = productMapper.toProductResponse(product);
        CategoryResponse categoryResponse = categoryMapper.toCategoryResponse(product.getCategory());
        List<ProductVariantResponse> productVariantResponses = productVariantMapper.toProductVariantResponseList(variants);
        List<ProductImagesResponse> productImagesResponses = productImageMapper.toProductImagesResponseList(images);

        productResponse.setCategory(categoryResponse);
        productResponse.setProductVariants(productVariantResponses);
        productResponse.setProductImages(productImagesResponses);

        return productResponse;
    }

}
