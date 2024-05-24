package com.ivymodal.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class CategoryDTO extends BaseDTO{
    String menu_title;
    String menu_link;
    List<ProductDTO> productDTO;
}
