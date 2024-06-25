package com.ivymodal.controller.web.api;

import com.ivymodal.dto.ApiResponse;
import com.ivymodal.dto.RegisterAccountUsers.request.UsersRequest;
import com.ivymodal.dto.RegisterAccountUsers.response.UsersResponse;
import com.ivymodal.service.admin.IRegisterAccountUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-website-register-account")
public class RegisterAccountUserAPI {
    @Autowired
    private IRegisterAccountUser registerAccountUser;

    @PostMapping
    public ApiResponse<UsersResponse> createAccount (@RequestBody UsersRequest request){
        ApiResponse<UsersResponse> apiResponse= new ApiResponse<>();
        apiResponse.setResult(registerAccountUser.createAccount(request));
        return apiResponse;
    }
}
