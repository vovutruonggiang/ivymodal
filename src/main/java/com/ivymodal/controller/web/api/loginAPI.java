package com.ivymodal.controller.web.api;

import com.ivymodal.dto.ApiResponse;
import com.ivymodal.dto.Authentication.request.AuthenticationRequest;
import com.ivymodal.dto.Authentication.response.AuthenticationResponse;
import com.ivymodal.service.admin.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class loginAPI {
    @Autowired
    private IAuthenticationService authenticationService;

    @PostMapping("/log-in")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        ApiResponse<AuthenticationResponse> apiResponse = new ApiResponse<>();
        boolean result = authenticationService.authenticate(request);
        apiResponse.setMessage("authentication: "+result);
        return apiResponse;
    }
}
