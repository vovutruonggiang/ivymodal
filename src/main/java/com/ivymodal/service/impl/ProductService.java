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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ProductWithVariantsDTO createProduct(ProductWithVariantsDTO productWithVariantsDTO) {
        // Chuyển đổi DTO -> Entity cho sản phẩm
        ProductEntity productEntity = productMapper.toEntity(productWithVariantsDTO.getProductDTO());
        // Lưu sản phẩm vào cơ sở dữ liệu
        productRepository.save(productEntity);

        // Tạo biến thể sản phẩm và hình ảnh sản phẩm
        createVariant(productEntity, productWithVariantsDTO);
        createImage(productEntity, productWithVariantsDTO);

        // Gọi phương thức EntityToDTO để chuyển đổi từ Entity sang DTO và trả về kết quả
        return EntityToDTO(productEntity, productWithVariantsDTO.getProductVariantDTOList(), productWithVariantsDTO.getProductImageDTOList());
    }

    @Override
    public ProductWithVariantsDTO updateProduct(int id, ProductWithVariantsDTO productWithVariantsDTO) {
        Optional<ProductEntity> existingProduct = productRepository.findById(id);
        if (!existingProduct.isPresent()) {
            throw new RuntimeException("Product with ID " + id + " does not exist.");
        }

        // Cập nhật thông tin sản phẩm chính
        ProductEntity productEntity = productMapper.toEntity(productWithVariantsDTO.getProductDTO());
        productEntity.setId(id);
        productRepository.save(productEntity);

        // Cập nhật thông tin sản phẩm biến thể
        updateVariant(productWithVariantsDTO);

        // Cập nhật thông tin hình sản phẩm theo màu
        updateImages(id,productWithVariantsDTO);

        // Gọi phương thức EntityToDTO để chuyển đổi từ Entity sang DTO và trả về kết quả
        return EntityToDTO(productEntity, productWithVariantsDTO.getProductVariantDTOList(), productWithVariantsDTO.getProductImageDTOList());

    }

    @Override
    public void deleteProduct(int id) {
        List<ProductImageEntity> productImageEntities = productImageRepository.findProductImageByIDProduct(id);
        for (ProductImageEntity productImageEntity : productImageEntities) {
            productImageRepository.deleteById(productImageEntity.getId());
        }
        List<ProductVariantEntity> productVariantEntities = productVariantRepository.findProductVariantByIDProduct(id);
        for (ProductVariantEntity productVariantEntity : productVariantEntities) {
            productVariantRepository.deleteById(productVariantEntity.getId());
        }

        List<ProductEntity> productEntities = productRepository.findProductByID(id);
        for (ProductEntity productEntity : productEntities) {
            productRepository.deleteById(productEntity.getId());
        }

    }

    public void updateVariant(ProductWithVariantsDTO productWithVariantsDTO) {
        List<ProductVariantEntity> productVariantEntities = productVariantMapper.toEntityList(productWithVariantsDTO.getProductVariantDTOList());
        for (ProductVariantEntity productVariantEntity : productVariantEntities) {
            ProductVariantEntity productVariant = new ProductVariantEntity();
            modelMapper.map(productVariantEntity, productVariant);
            productVariantRepository.save(productVariant);
        }

    }

    public void updateImages(int id, ProductWithVariantsDTO productWithVariantsDTO) {
        List<ProductImageEntity> productImageEntities = productImageMapper.toEntityList(productWithVariantsDTO.getProductImageDTOList());
        for (ProductImageEntity productImageEntity : productImageEntities) {
            ProductImageEntity productImage = new ProductImageEntity();
            modelMapper.map(productImageEntity, productImage);
            productImageRepository.save(productImage);
        }
    }

    public void createVariant(ProductEntity productEntity, ProductWithVariantsDTO productWithVariantsDTO) {
        // Chuyển đổi danh sách từ DTO sang Entity bằng mapper
        List<ProductVariantEntity> productVariantEntities = productVariantMapper.toEntityList(productWithVariantsDTO.getProductVariantDTOList());
        // Thiết lập thực thể sản phẩm cho mỗi biến thể sản phẩm
        for (ProductVariantEntity productVariantEntity : productVariantEntities) {
            productVariantEntity.setProduct(productEntity);
        }
        productVariantRepository.saveAll(productVariantEntities);
    }


    public void createImage(ProductEntity productEntity, ProductWithVariantsDTO productWithVariantsDTO) {
        // Chuyển đổi danh sách từ DTO sang Entity bằng mapper
        List<ProductImageEntity> productImageEntities = productImageMapper.toEntityList(productWithVariantsDTO.getProductImageDTOList());
        // Thiết lập thực thể hình cho mỗi biến thể sản phẩm
        for (ProductImageEntity productImageEntity : productImageEntities) {
            productImageEntity.setProduct(productEntity);
        }
        // thêm vào database
        productImageRepository.saveAll(productImageEntities);
    }


    public ProductWithVariantsDTO EntityToDTO(ProductEntity productEntity, List<ProductVariantDTO> productVariantDTOs, List<ProductImageDTO> productImageDTOs) {
        // Chuyển đổi từ Entity -> DTO cho sản phẩm
        ProductDTO productDTO = productMapper.toDTO(productEntity);

        // Đặt DTO vào đối tượng ProductWithVariant
        ProductWithVariantsDTO productWithVariantsDTO = new ProductWithVariantsDTO();
        productWithVariantsDTO.setProductDTO(productDTO);
        productWithVariantsDTO.setProductVariantDTOList(productVariantDTOs);
        productWithVariantsDTO.setProductImageDTOList(productImageDTOs);

        return productWithVariantsDTO;
    }

}
