package com.ivymodal.service.web.impl;

import com.ivymodal.dto.Product.response.ProductDto;
import com.ivymodal.dto.ProductVariant.response.VariantDto;
import com.ivymodal.entity.Category;
import com.ivymodal.entity.Product;
import com.ivymodal.entity.ProductVariant;
import com.ivymodal.repository.CategoryRepository;
import com.ivymodal.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductWebService  {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<ProductDto> getAllProduct() {
        Optional<Category> category = categoryRepository.findCategoryByName("nu");
        List<Product> products = productRepository.findByCategoryId(category.get().getId());
        List<ProductDto> productDtos = new ArrayList<>();

        for (Product product : products) {
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setName(product.getName());
            productDto.setId_category(product.getCategory().getId());
            productDto.setThumbnail(product.getThumbnail());

            List<VariantDto> variantDtos = new ArrayList<>();
            Set<String> colors = new HashSet<>();

            for (ProductVariant variant : product.getProductVariant()){
                if (!colors.contains(variant.getColor().getName())) {
                    VariantDto variantDto = new VariantDto();
                    variantDto.setColor(variant.getColor().getColor_coding());
                    variantDto.setSize(new ArrayList<>());
                    variantDto.setPrice(variant.getPrice());
                    variantDto.setStatus(variant.getStatus());
                    variantDto.setStock(variant.getStock());
                    variantDto.setId(variant.getId());
                    colors.add(variant.getColor().getName());
                    variantDtos.add(variantDto);
                }
                VariantDto existingVariantDto = variantDtos.stream()
                        .filter(v -> v.getColor().equals(variant.getColor().getColor_coding()))
                        .findFirst()
                        .orElse(null);

                if (existingVariantDto != null) {
                    existingVariantDto.getSize().add(variant.getSize().getName());
                }
            }
            productDto.setProductVariants(variantDtos);
            productDtos.add(productDto);
        }
        return productDtos;
    }
}
