package com.ivymodal.dto.User.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResquest {
    String fullname;
    Date date_of_birth;
    Boolean gender;
    String city_of_province;
    String country_of_district;
    String ward_of_commune;
    String adress;
}
