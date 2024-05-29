//package com.ivymodal.service.impl;
//
//import com.ivymodal.dto.AccountDTO;
//import com.ivymodal.dto.AccountWithUserDTO;
//import com.ivymodal.dto.UserDTO;
//import com.ivymodal.entity.AccountEntity;
//import com.ivymodal.entity.UserEntity;
//import com.ivymodal.mapper.AccountMapper;
//import com.ivymodal.mapper.UserMapper;
//import com.ivymodal.repository.AccountRepository;
//import com.ivymodal.repository.UserRepository;
//import com.ivymodal.service.IAccountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AccountService implements IAccountService {
//    @Autowired
//    private AccountRepository accountRepository;
//    @Autowired
//    private AccountMapper accountMapper;
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    public AccountWithUserDTO createAccount(AccountWithUserDTO accountWithUserDTO) {
//        saveAccount(accountWithUserDTO);
//        saveUser(accountWithUserDTO);
//        return accountWithUserDTO;
//    }
//
//    @Override
//    public AccountDTO updateAccount(int id, AccountDTO accountDTO) {
//        AccountEntity accountEntity = accountMapper.toEntity(accountDTO);
//        accountEntity.setId(id);
//        accountEntity =  accountRepository.save(accountEntity);
//        return accountMapper.toDTO(accountEntity);
//    }
//
//
//    @Override
//    public void deleteAccount(int id) {
//        deleteUser(id);
//        deleteAcount(id);
//    }
//
//    public AccountDTO saveAccount(AccountWithUserDTO accountWithUserDTO){
//        AccountEntity accountEntity = accountMapper.toEntity(accountWithUserDTO.getAccount());
//        accountEntity = accountRepository.save(accountEntity);
//        return accountMapper.toDTO(accountEntity);
//    }
//    public UserDTO saveUser(AccountWithUserDTO accountWithUserDTO){
//        UserEntity userEntity = userMapper.toEntity(accountWithUserDTO.getUser());
//        userEntity = userRepository.save(userEntity);
//        return userMapper.toDTO(userEntity);
//    }
//
//    public void deleteAcount(int id){
//        accountRepository.deleteById(id);
//    }
//
//    public void deleteUser(int id){
//        UserEntity userEntity = userRepository.findUserByID(id);
//        userRepository.deleteById(userEntity.getId());
//    }
//}
