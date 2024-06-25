package com.ivymodal.service.admin;

import com.ivymodal.dto.Authentication.request.AuthenticationRequest;

public interface IAuthenticationService {
    boolean authenticate(AuthenticationRequest request);
}
