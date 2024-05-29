//package com.ivymodal.controller.admin.api;
//
//import com.ivymodal.dto.RolesDTO;
//import com.ivymodal.service.IRolesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api-admin-roles")
//public class RolesAPI {
//    @Autowired
//    private IRolesService rolesService;
//
//    @PostMapping
//    public RolesDTO createRoles (@RequestBody RolesDTO roles) {
//        return rolesService.createRole(roles);
//    }
//
//    @PutMapping("/{id}")
//    public RolesDTO updateRoles (@PathVariable int id,@RequestBody RolesDTO roles) {
//        return rolesService.updateRole(id,roles);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteRoles (@PathVariable int id) {
//        rolesService.deleteRole(id);
//    }
//}
