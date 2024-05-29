//package com.ivymodal.service.impl;
//
//import com.ivymodal.dto.DiscountDTO;
//import com.ivymodal.entity.DiscountEntity;
//import com.ivymodal.mapper.DiscountMapper;
//import com.ivymodal.repository.DiscountRepository;
//import com.ivymodal.service.IDiscountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class DiscountService implements IDiscountService {
//
//    @Autowired
//    private DiscountRepository discountRepository;
//    @Autowired
//    private DiscountMapper discountMapper;
//
//    @Override
//    public DiscountDTO createDiscount(DiscountDTO discountDTO) {
//        DiscountEntity discountEntity = discountMapper.toEntity(discountDTO);
//        discountEntity = discountRepository.save(discountEntity);
//        return discountMapper.toDTO(discountEntity);
//    }
//
//    @Override
//    public DiscountDTO updateDiscount(int id, DiscountDTO discountDTO) {
//        DiscountEntity discountEntity = discountRepository.findById(id).get();
//        discountEntity = discountMapper.toEntity(discountDTO);
//        discountEntity.setId(id);
//        discountEntity = discountRepository.save(discountEntity);
//        return discountMapper.toDTO(discountEntity);
//    }
//
//    @Override
//    public void deleteDiscount(int id) {
//        discountRepository.deleteById(id);
//    }
//}
