package com.ivymodal.dto.Size.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SizeProductDetailResponse {
     String size;
     String variantId;
     double price;
     boolean status;
     int stock;
}
