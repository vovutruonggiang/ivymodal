package com.ivymodal.dto.Color.response;

import com.ivymodal.dto.BaseDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ColorResponse extends BaseDTO {
    String name;
    String color_coding;
}
