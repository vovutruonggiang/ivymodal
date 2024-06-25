package com.ivymodal.service.admin.impl;

import com.ivymodal.dto.RegisterAccountUsers.request.UsersRequest;
import com.ivymodal.dto.RegisterAccountUsers.response.UsersResponse;
import com.ivymodal.entity.Users;
import com.ivymodal.exception.AppException;
import com.ivymodal.exception.ErrorCode;
import com.ivymodal.mapper.UsersMapper;
import com.ivymodal.repository.UsersRepository;
import com.ivymodal.service.admin.IRegisterAccountUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterAccountUser implements IRegisterAccountUser {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UsersResponse createAccount(UsersRequest request) {
        if(usersRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.ACCOUNT_USER_EXISTED);
        Users user = usersMapper.toUsers(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return usersMapper.toUsersResponse(usersRepository.save(user));
    }
}
