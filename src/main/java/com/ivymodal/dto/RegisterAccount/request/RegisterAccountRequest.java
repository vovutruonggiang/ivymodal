package com.ivymodal.dto.RegisterAccount.request;

import com.ivymodal.dto.Account.request.AccountResquest;
import com.ivymodal.dto.User.request.UserResquest;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterAccountRequest {
    AccountResquest accountResquest;
    UserResquest userResquest;
}
