//package com.ivymodal.controller.admin.api;
//
//import com.ivymodal.dto.UserDTO;
//import com.ivymodal.service.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api-admin-user")
//public class UserAPI {
//    @Autowired
//    private IUserService userService;
//
//    @PutMapping("{id}")
//    public UserDTO updateUser (@PathVariable Integer id, @RequestBody UserDTO userDTO) {
//        return userService.updateUser(id,userDTO);
//    }
//}
