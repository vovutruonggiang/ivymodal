package com.ivymodal.mapper;

import com.ivymodal.dto.RegisterAccountUsers.request.UsersRequest;
import com.ivymodal.dto.RegisterAccountUsers.response.UsersResponse;
import com.ivymodal.entity.Users;
import org.apache.catalina.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UsersMapper{
    Users toUsers (UsersRequest request);

    UsersResponse toUsersResponse (Users user);

    void updateUsers(@MappingTarget User user,UsersRequest usersRequest);

}
