package com.ivymodal.dto;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class DiscountDTO extends BaseDTO{
    Date strar_time;
    Date end_time;
    String despcription;
    String discount_type;
    Float discount_value;
    int status;

}
