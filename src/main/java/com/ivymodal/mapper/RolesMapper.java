package com.ivymodal.mapper;

import com.ivymodal.dto.Roles.request.RolesRequest;
import com.ivymodal.dto.Roles.response.RolesResponse;
import com.ivymodal.entity.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface RolesMapper{
    Roles toRoles(RolesRequest request);

    RolesResponse toRolesResponse(Roles roles);

    void updateRoles(@MappingTarget Roles rolesRequest, RolesRequest response);
}
