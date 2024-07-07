package com.ivymodal.dto.Account.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountResquest {
    String username;
    String password;
    String email;
    String id_roles;
}
