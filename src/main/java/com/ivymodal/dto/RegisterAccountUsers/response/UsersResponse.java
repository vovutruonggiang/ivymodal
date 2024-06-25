package com.ivymodal.dto.RegisterAccountUsers.response;

import com.ivymodal.dto.BaseDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsersResponse extends BaseDTO {
    String fullname;
    Date date_of_birth;
    Boolean gender;
    String city_of_province;
    String country_of_district;
    String ward_of_commune;
    String adress;
    String username;
    String password;
    String email;
}
