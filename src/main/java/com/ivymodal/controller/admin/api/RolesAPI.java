package com.ivymodal.controller.admin.api;

import com.ivymodal.dto.ApiResponse;
import com.ivymodal.dto.Roles.request.RolesDeleteRequest;
import com.ivymodal.dto.Roles.request.RolesRequest;
import com.ivymodal.dto.Roles.response.RolesResponse;
import com.ivymodal.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-admin-roles")
public class RolesAPI {
    @Autowired
    private IRolesService rolesService;

    @PostMapping
    public ApiResponse<RolesResponse> createRoles (@RequestBody RolesRequest request) {
        ApiResponse<RolesResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(rolesService.createRole(request));
        return apiResponse;
    }

    @PutMapping("/{rolesId}")
    public ApiResponse<RolesResponse> updateRoles (@PathVariable String rolesId,@RequestBody RolesRequest request) {
        ApiResponse<RolesResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(rolesService.updateRole(rolesId, request));
        return apiResponse;
    }

    @DeleteMapping
    public ApiResponse<RolesResponse> deleteRoles (@PathVariable RolesDeleteRequest request) {
        ApiResponse<RolesResponse> apiResponse = new ApiResponse<>();
        rolesService.deleteRole(request.getRolesIds());
        apiResponse.setMessage("Delete success");
        return apiResponse;
    }
}
