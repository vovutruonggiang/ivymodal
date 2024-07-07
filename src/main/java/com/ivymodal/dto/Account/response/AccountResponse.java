package com.ivymodal.dto.Account.response;

import com.ivymodal.dto.BaseDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountResponse extends BaseDTO {
    String username;
    String password;
    String email;
//    RolesResponse role;
}
