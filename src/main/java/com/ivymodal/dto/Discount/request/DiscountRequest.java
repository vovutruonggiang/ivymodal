package com.ivymodal.dto.Discount.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountRequest {
    String name;
    Date start_time;
    Date end_time;
    String descriptions;
    String discount_type;
    Float discount_value;
    Boolean status;
}
