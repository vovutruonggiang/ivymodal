//package com.ivymodal.controller.admin.api;
//
//import com.ivymodal.dto.AddDiscountDTO;
//import com.ivymodal.service.impl.AddDiscountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api-admin-add-discount")
//public class AddDiscountAPI {
//    @Autowired
//    private AddDiscountService addDiscountService;
//
//    @PostMapping
//    public List<AddDiscountDTO> createAddDiscount(@RequestBody List<AddDiscountDTO> addDiscountDTO) {
//        return addDiscountService.createDiscount(addDiscountDTO);
//    }
//
//    @DeleteMapping
//    public void deleteAddDiscount(@RequestBody AddDiscountDTO addDiscountDTO) {
//        addDiscountService.deleteDiscount(addDiscountDTO.getIds());
//    }
//}
