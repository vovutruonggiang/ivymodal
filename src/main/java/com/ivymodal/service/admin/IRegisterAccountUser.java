package com.ivymodal.service.admin;

import com.ivymodal.dto.RegisterAccountUsers.request.UsersRequest;
import com.ivymodal.dto.RegisterAccountUsers.response.UsersResponse;

public interface IRegisterAccountUser {
    UsersResponse createAccount(UsersRequest request);
}
