package com.ivymodal.dto.Category.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class CategoryRequest {
    String name;
    String menu_link;
    String menuParentId;
}
