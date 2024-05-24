package com.ivymodal.controller.admin.api;

import com.ivymodal.dto.ProductWithVariantsDTO;
import com.ivymodal.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-admin-product")
public class ProductAPI {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductWithVariantsDTO createProductWithVariants(@RequestBody ProductWithVariantsDTO productWithVariantsDTO) {
        return productService.createProduct(0,productWithVariantsDTO);
    }

    @PutMapping("/{id}")
    public ProductWithVariantsDTO updateProduct(@RequestBody ProductWithVariantsDTO productWithVariantsDTO,@PathVariable int id) {
        return productService.updateProduct(id, productWithVariantsDTO);
    }
}
