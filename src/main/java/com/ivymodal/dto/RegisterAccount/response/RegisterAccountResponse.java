package com.ivymodal.dto.RegisterAccount.response;

import com.ivymodal.dto.Account.response.AccountResponse;
import com.ivymodal.dto.BaseDTO;
import com.ivymodal.dto.User.response.UserResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterAccountResponse extends BaseDTO {
    AccountResponse accountResponse;
    UserResponse userResponse;
}
