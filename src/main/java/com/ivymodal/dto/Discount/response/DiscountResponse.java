package com.ivymodal.dto.Discount.response;

import com.ivymodal.dto.BaseDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Data
@FieldDefaults (level = AccessLevel.PRIVATE)
public class DiscountResponse extends BaseDTO {
    String name;
    Date start_time;
    Date end_time;
    String descriptions;
    String discount_type;
    Float discount_value;
    Boolean status;
}
