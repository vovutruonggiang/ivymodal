//package com.ivymodal.service.impl;
//
//import com.ivymodal.dto.UserDTO;
//import com.ivymodal.entity.UserEntity;
//import com.ivymodal.mapper.UserMapper;
//import com.ivymodal.repository.UserRepository;
//import com.ivymodal.service.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService implements IUserService {
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    public UserDTO updateUser(int id,UserDTO userDTO) {
//        UserEntity userEntity = userMapper.toEntity(userDTO);
//        userEntity.setId(id);
//        userRepository.save(userEntity);
//        return userMapper.toDTO(userEntity);
//    }
//}
