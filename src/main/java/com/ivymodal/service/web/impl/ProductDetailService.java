package com.ivymodal.service.web.impl;

import com.ivymodal.dto.Color.response.ColorProductDetailResponse;
import com.ivymodal.dto.Color.response.ColorResponse;
import com.ivymodal.dto.Product.response.ProductDetail;
import com.ivymodal.dto.Product.response.ProductDto;
import com.ivymodal.dto.ProductImages.response.ProductImagesResponse;
import com.ivymodal.dto.ProductVariant.response.VariantDto;
import com.ivymodal.dto.ProductVariant.response.VariantProductDetailResponse;
import com.ivymodal.dto.Size.response.SizeProductDetailResponse;
import com.ivymodal.entity.Color;
import com.ivymodal.entity.Product;
import com.ivymodal.entity.ProductImage;
import com.ivymodal.entity.ProductVariant;
import com.ivymodal.repository.ProductImageRepository;
import com.ivymodal.repository.ProductRepository;
import com.ivymodal.service.web.IProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductDetailService implements IProductDetailService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImageRepository productImageRepository;

    @Override
    public ProductDetail getAllProductDetail(String idProduct) {
        Optional<Product> product = productRepository.findById(idProduct);

        ProductDetail productDetail = new ProductDetail();
        productDetail.setId(product.get().getId());
        productDetail.setName(product.get().getName());
        productDetail.setDescription(product.get().getDescription());
        productDetail.setThumbnail(product.get().getThumbnail());
        productDetail.setId_category(product.get().getCategory().getId());

        List<VariantProductDetailResponse> variantDtos  = new ArrayList<>();
        Set<String> colors = new HashSet<>();

        for (ProductVariant variant : product.get().getProductVariant()){
            if(!colors.contains(variant.getColor().getName())){
                VariantProductDetailResponse variantDto = new VariantProductDetailResponse();
                Optional<ProductImage> productImage = productImageRepository.findOneByProductIdAndProductId(variant.getColor().getId(), variant.getProduct().getId());
                variantDto.setColor(variant.getColor().getColor_coding());
                variantDto.setSize(new ArrayList<>());
                variantDto.setImage_url(productImage.get().getImage_url());
                colors.add(variant.getColor().getName());
                variantDtos .add(variantDto);
            }
            VariantProductDetailResponse existingVariantDto = variantDtos.stream()
                    .filter(v -> v.getColor().equals(variant.getColor().getColor_coding()))
                    .findFirst()
                    .orElse(null);

            if (existingVariantDto != null) {
                SizeProductDetailResponse sizeDto = new SizeProductDetailResponse();
                sizeDto.setSize(variant.getSize().getName());
                sizeDto.setVariantId(variant.getId());
                sizeDto.setPrice(variant.getPrice());
                sizeDto.setStatus(variant.getStatus());
                sizeDto.setStock(variant.getStock());
                existingVariantDto.getSize().add(sizeDto);
            }
        }

        productDetail.setProductVariants(variantDtos);
        return productDetail;
    }
}
