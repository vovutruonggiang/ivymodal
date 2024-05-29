//package com.ivymodal.controller.admin.api;
//
//import com.ivymodal.dto.AccountDTO;
//import com.ivymodal.dto.AccountWithUserDTO;
//import com.ivymodal.service.IAccountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api-admin-account")
//public class AccountAPI {
//    @Autowired
//    private IAccountService accountService;
//
//    @PostMapping
//    public AccountWithUserDTO createAccount(@RequestBody AccountWithUserDTO accountWithUserDTO) {
//        return accountService.createAccount(accountWithUserDTO);
//    }
//
//    @PutMapping("{id}")
//    public AccountDTO updateAccount(@PathVariable int id, @RequestBody AccountDTO accountDTO) {
//        return accountService.updateAccount(id,accountDTO);
//    }
//
//    @DeleteMapping("{id}")
//    public void deleteAccount(@PathVariable int id) {
//        accountService.deleteAccount(id);
//    }
//}
