package com.ivymodal.dto.Category.response;

import com.ivymodal.dto.BaseDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class CategoryResponse extends BaseDTO {
    String name;
    List<CategoryResponse> subCategories;
}
