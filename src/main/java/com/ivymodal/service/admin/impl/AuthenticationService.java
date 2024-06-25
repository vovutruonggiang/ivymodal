package com.ivymodal.service.admin.impl;

import com.ivymodal.dto.Authentication.request.AuthenticationRequest;
import com.ivymodal.exception.AppException;
import com.ivymodal.exception.ErrorCode;
import com.ivymodal.repository.UsersRepository;
import com.ivymodal.service.admin.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public boolean authenticate(AuthenticationRequest request) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        var user = usersRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return passwordEncoder.matches(request.getPassword(),user.getPassword());
    }
}
