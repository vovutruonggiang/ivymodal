package com.ivymodal.service.impl;

import com.ivymodal.dto.Roles.request.RolesRequest;
import com.ivymodal.dto.Roles.response.RolesResponse;
import com.ivymodal.entity.Roles;
import com.ivymodal.mapper.RolesMapper;
import com.ivymodal.repository.RolesRepository;
import com.ivymodal.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesSerivice implements IRolesService {
    @Autowired
    RolesRepository rolesRepository;
    @Autowired
    RolesMapper rolesMapper;

    @Override
    public RolesResponse createRole(RolesRequest request) {
        Roles roles= rolesMapper.toRoles(request);
        return rolesMapper.toRolesResponse(rolesRepository.save(roles));
    }

    @Override
    public RolesResponse updateRole(String rolesId, RolesRequest request) {
        Roles roles = new Roles();
        rolesMapper.updateRoles(roles,request);
        return rolesMapper.toRolesResponse(rolesRepository.save(roles));
    }

    @Override
    public void deleteRole(String[] rolesId) {
        for (String roleId : rolesId) {
            rolesRepository.deleteById(roleId);
        }
    }
}
