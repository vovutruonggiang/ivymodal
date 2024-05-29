//package com.ivymodal.service.impl;
//
//import com.ivymodal.dto.RolesDTO;
//import com.ivymodal.entity.RolesEntity;
//import com.ivymodal.mapper.RolesMapper;
//import com.ivymodal.repository.RolesRepository;
//import com.ivymodal.service.IRolesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RolesSerivice implements IRolesService {
//    @Autowired
//    RolesRepository rolesRepository;
//    @Autowired
//    RolesMapper rolesMapper;
//
//    @Override
//    public RolesDTO createRole(RolesDTO rolesDTO) {
//        RolesEntity rolesEntity = rolesMapper.toEntity(rolesDTO);
//        rolesEntity = rolesRepository.save(rolesEntity);
//        return rolesMapper.toDTO(rolesEntity);
//    }
//
//    @Override
//    public RolesDTO updateRole(int id, RolesDTO rolesDTO) {
//        RolesEntity rolesEntity = rolesMapper.toEntity(rolesDTO);
//        rolesEntity.setId(id);
//        rolesEntity = rolesRepository.save(rolesEntity);
//        return rolesMapper.toDTO(rolesEntity);
//    }
//
//    @Override
//    public void deleteRole(int id) {
//        rolesRepository.deleteById(id);
//    }
//}
