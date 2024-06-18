package com.ivymodal.service;

import com.ivymodal.dto.Roles.request.RolesRequest;
import com.ivymodal.dto.Roles.response.RolesResponse;

public interface IRolesService {
    RolesResponse createRole(RolesRequest request);
    RolesResponse updateRole(String rolesId,RolesRequest rolesDTO);
    void deleteRole(String[] rolesId);
}
