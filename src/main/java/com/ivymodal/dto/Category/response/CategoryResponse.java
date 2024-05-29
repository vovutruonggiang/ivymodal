package com.ivymodal.dto.Category.response;

import com.ivymodal.dto.BaseDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class CategoryResponse extends BaseDTO {
    String name;
    String menu_link;
    String menu_parent_id;
}
