package com.ivymodal.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ProductImageDTO extends BaseDTO{
    ProductDTO productDTO;
    ColorDTO colorDTO;
    String image_url;

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public ColorDTO getColorDTO() {
        return colorDTO;
    }

    public void setColorDTO(ColorDTO colorDTO) {
        this.colorDTO = colorDTO;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
