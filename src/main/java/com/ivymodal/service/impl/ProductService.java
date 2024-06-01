package com.ivymodal.service.impl;

import com.ivymodal.dto.Product.response.ProductResponse;
import com.ivymodal.dto.ProductImages.response.ProductImagesResponse;
import com.ivymodal.dto.ProductVariant.response.ProductVariantResponse;
import com.ivymodal.dto.ProductVariantImages.request.ProductVariantImagesRequest;
import com.ivymodal.dto.ProductVariantImages.response.ProductListResponse;
import com.ivymodal.dto.ProductVariantImages.response.ProductVariantImagesResponse;
import com.ivymodal.entity.Product;
import com.ivymodal.entity.ProductImage;
import com.ivymodal.entity.ProductVariant;
import com.ivymodal.exception.AppException;
import com.ivymodal.exception.ErrorCode;
import com.ivymodal.mapper.ProductImageMapper;
import com.ivymodal.mapper.ProductMapper;
import com.ivymodal.mapper.ProductVariantMapper;
import com.ivymodal.repository.ProductImageRepository;
import com.ivymodal.repository.ProductRepository;
import com.ivymodal.repository.ProductVariantRepository;
import com.ivymodal.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private ProductImageRepository productImageRepository;

    @Autowired
    private ProductImageMapper productImageMapper;

    @Override
    public ProductVariantImagesResponse createProduct(ProductVariantImagesRequest request) {
        if(productRepository.existsByName(request.getProduct().getName()))
            throw new AppException(ErrorCode.PRODUCT_EXISTED);
        Product product = productMapper.toProduct(request.getProduct());
        product = productRepository.save(product);

        List<ProductVariant> productVariants = productVariantMapper.toProductVariantList(request.getProductVariant());
        for (ProductVariant productVariant : productVariants) {
            productVariant.setProduct(product);
        }
        productVariantRepository.saveAll(productVariants);

        List<ProductImage> productImages = productImageMapper.toProductImagesList(request.getProductImage());
        for(int i=0; i<productImages.size(); i++){
            ProductImage productImage = productImages.get(i);
            productImage.setProduct(product);
            if(i<productVariants.size()){
                productImage.setColor(productVariants.get(i).getColor());
            }
        }
        productImageRepository.saveAll(productImages);
        return buildProductVariantImagesResponse(product,productVariants,productImages);
    }

    @Override
    public ProductVariantImagesResponse updateProduct(String productId, ProductVariantImagesRequest request) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        productMapper.updateProduct(product,request.getProduct());
        productRepository.save(product);

        List<ProductVariant> productVariantOld = productVariantRepository.findByProductId(productId);
        System.out.println("size: " + productVariantOld.size());

        List<ProductVariant> productVariants = productVariantMapper.toProductVariantList(request.getProductVariant());
        for(int i=0; i<productVariants.size(); i++){
            if(i<productVariantOld.size()){
                productVariants.get(i).setId(productVariantOld.get(i).getId());
                productVariants.get(i).setProduct(product);
            }
        }
        productVariantRepository.saveAll(productVariants);

        List<ProductImage> productImageOld = productImageRepository.findByProductId(productId);

        List<ProductImage> productImages = productImageMapper.toProductImagesList(request.getProductImage());
        for(int i=0; i<productImages.size(); i++){
            if(i<productImageOld.size()){
                productImages.get(i).setColor(productImageOld.get(i).getColor());
                productImages.get(i).setId(productImageOld.get(i).getId());
                productImages.get(i).setProduct(product);
            }
        }
        productImageRepository.saveAll(productImages);
        return buildProductVariantImagesResponse(product,productVariants,productImages);
    }

    @Override
    public ProductListResponse getProductList() {
        List<Product> products = productRepository.findAll();
        List<ProductVariant> productVariants = productVariantRepository.findAll();
        List<ProductImage> productImages = productImageRepository.findAll();
        return buildProductList(products,productVariants,productImages);
    }

    public ProductListResponse buildProductList(List<Product> products,List<ProductVariant> productVariants,List<ProductImage> productImages){
       for(Product product : products){
           System.out.println("product" + product.getId());
           for(ProductVariant productVariant : productVariants){
               if(product.getId().equals(productVariant.getProduct().getId())){
                   System.out.println("product variant" + productVariant.getId());
               }
           }
           for(ProductImage productImage : productImages){
               if(product.getId().equals(productImage.getProduct().getId())){
                   System.out.println("product Images" +productImage.getId());
               }
           }
       }

        return null;
    }

    public ProductVariantImagesResponse buildProductVariantImagesResponse (Product product,List<ProductVariant> productVariants,List<ProductImage> productImages){
        ProductResponse productResponse = productMapper.toProductResponse(product);
        List<ProductVariantResponse> productVariantResponses = productVariantMapper.toProductVariantResponseList(productVariants);
        List<ProductImagesResponse> productImagesResponses = productImageMapper.toProductImagesResponseList(productImages);

        ProductVariantImagesResponse productVariantImagesResponse = new ProductVariantImagesResponse();
        productVariantImagesResponse.setProduct(productResponse);
        productVariantImagesResponse.setProductVariant(productVariantResponses);
        productVariantImagesResponse.setProductVariantImages(productImagesResponses);
        return productVariantImagesResponse;
    }

}
