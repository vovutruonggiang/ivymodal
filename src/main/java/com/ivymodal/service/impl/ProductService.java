package com.ivymodal.service.impl;

import com.ivymodal.dto.*;
import com.ivymodal.entity.ColorEntity;
import com.ivymodal.entity.ProductEntity;
import com.ivymodal.entity.ProductImageEntity;
import com.ivymodal.entity.ProductVariantEntity;
import com.ivymodal.mapper.ColorMapper;
import com.ivymodal.mapper.ProductImageMapper;
import com.ivymodal.mapper.ProductMapper;
import com.ivymodal.mapper.ProductVariantMapper;
import com.ivymodal.repository.ColorRepository;
import com.ivymodal.repository.ProductImageRepository;
import com.ivymodal.repository.ProductRepository;
import com.ivymodal.repository.ProductVariantRepository;
import com.ivymodal.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
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

    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private ColorMapper colorMapper;

    @Override
    public ProductWithVariantsDTO saveProduct(int id,ProductWithVariantsDTO productWithVariantsDTO,boolean isUpdate) {
        //conversion dto -> entity
        ProductEntity productEntity = productMapper.toEntity(productWithVariantsDTO.getProductDTO());
        //create product
        productEntity.setId(id);
        ProductEntity saveproductEntity = productRepository.save(productEntity);

        //conversion dto -> entity
        List<ProductVariantEntity> productVariantEntities = productWithVariantsDTO.getProductVariantDTOList().stream()
                .map(productVariantDTO -> {
                    ProductVariantEntity productVariantEntity = productVariantMapper.toEntity(productVariantDTO);
                    productVariantEntity.setProduct(saveproductEntity);
                    return productVariantEntity;
                })
                .collect(Collectors.toList());



        // Lưu hoặc cập nhật các biến thể sản phẩm
        for (ProductVariantEntity productVariantEntity : productVariantEntities) {
            List<ProductVariantEntity> listProductVariantEntity = productVariantRepository.findProductVariantByIDProduct(id);
            for(ProductVariantEntity productVariantEntity2 : listProductVariantEntity){
                if (isUpdate) {
                    Optional<ProductVariantEntity> existingVariantOpt = productVariantRepository.findById(productVariantEntity2.getId());
                    if (existingVariantOpt.isPresent()) {
                        ProductVariantEntity existingVariant = new ProductVariantEntity();
                        existingVariant.setPrice(productVariantEntity.getPrice());
                        existingVariant.setStatus(productVariantEntity.getStatus());
                        existingVariant.setStock(productVariantEntity.getStock());
                        existingVariant.setProduct(productVariantEntity.getProduct());
                        existingVariant.setColor(productVariantEntity.getColor());
                        existingVariant.setSize(productVariantEntity.getSize());
                        productVariantRepository.save(existingVariant);
                    } else {
                        productVariantRepository.saveAll(productVariantEntities);
                    }
                } else {
                    productVariantRepository.saveAll(productVariantEntities);
                }
            }
        }

        //conversion dto -> entity
        List<ProductImageEntity> productImageEntities = productWithVariantsDTO.getProductImageDTOList().stream()
                .map(productImageDTO -> {
                    ProductImageEntity productImageEntity = productImageMapper.toEntity(productImageDTO);
                    productImageEntity.setProduct(saveproductEntity);
                    if(productImageDTO.getColorDTO() != null){
                        ColorEntity colorEntity = colorMapper.toEntity(productImageDTO.getColorDTO());
                        productImageEntity.setColor(colorEntity);
                    }
                    return productImageEntity;
                })
                .collect(Collectors.toList());

//        create product images
        productImageEntities = productImageRepository.saveAll(productImageEntities);

        //chuyen doi tu entity -> dto
        ProductDTO productDTO = productMapper.toDTO(saveproductEntity);

        //chuyen doi tu entity -> dto
        List<ProductVariantDTO> productVariantDTOS = productVariantEntities.stream()
                .map(productVariantEntity -> {
                    ProductVariantDTO productVariantDTO = productVariantMapper.toDTO(productVariantEntity);
                    productVariantDTO.setProduct(productDTO);
                    return productVariantDTO;
                })
                .collect(Collectors.toList());

        //conversion entity -> dto
        List<ProductImageDTO> productImageDTOS = productImageEntities.stream()
                .map(productImageEntity -> {
                    ProductImageDTO productImageDTO = productImageMapper.toDTO(productImageEntity);
                    productImageDTO.setProductDTO(productDTO);
                    if(productImageEntity.getColor() != null){
                        ColorDTO colorDTO = colorMapper.toDTO(productImageEntity.getColor());
                        productImageDTO.setColorDTO(colorDTO);
                    }
                    return productImageDTO;
                }).collect(Collectors.toList());

        //set dto vao doi tuong ProductWithVariant
        ProductWithVariantsDTO productWithVariantsDTOList = new ProductWithVariantsDTO();
        productWithVariantsDTOList.setProductDTO(productDTO);
        productWithVariantsDTOList.setProductVariantDTOList(productVariantDTOS);
        productWithVariantsDTOList.setProductImageDTOList(productImageDTOS);
        return productWithVariantsDTOList;
    }

    @Override
    public ProductWithVariantsDTO createProduct(int id, ProductWithVariantsDTO productWithVariantsDTO) {
        return saveProduct(id, productWithVariantsDTO,false);
    }

    @Override
    public ProductWithVariantsDTO updateProduct(int id, ProductWithVariantsDTO productWithVariantsDTO) {
        return saveProduct(id, productWithVariantsDTO, true);
    }
}
