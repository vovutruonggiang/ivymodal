package com.ivymodal.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class CategoryCreationRequest{
    String name;
    String menu_link;
    int menu_parent_id;
}
