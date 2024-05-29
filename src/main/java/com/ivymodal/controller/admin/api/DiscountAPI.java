//package com.ivymodal.controller.admin.api;
//
//import com.ivymodal.dto.DiscountDTO;
//import com.ivymodal.service.impl.DiscountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api-admin-discount")
//public class DiscountAPI {
//    @Autowired
//    private DiscountService discountService;
//
//
//    @PostMapping
//    public DiscountDTO createDiscount(@RequestBody DiscountDTO discountDTO){
//        return discountService.createDiscount(discountDTO);
//    }
//
//    @PutMapping("{id}")
//    public DiscountDTO updateDiscount(@PathVariable int id, @RequestBody DiscountDTO discountDTO){
//        return discountService.updateDiscount(id, discountDTO);
//    }
//
//    @DeleteMapping("delete/{id}")
//    public void deleteDiscount(@PathVariable int id){
//        discountService.deleteDiscount(id);
//    }
//}
