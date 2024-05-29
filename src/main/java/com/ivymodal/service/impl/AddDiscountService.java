//package com.ivymodal.service.impl;
//
//import com.ivymodal.dto.AddDiscountDTO;
//import com.ivymodal.entity.AddDiscountEntity;
//import com.ivymodal.mapper.AddDiscountMapper;
//import com.ivymodal.repository.AddDiscountRepository;
//import com.ivymodal.service.IAddDiscountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public class AddDiscountService implements IAddDiscountService {
//    @Autowired
//    private AddDiscountRepository addDiscountRepository;
//
//    @Autowired
//    private AddDiscountMapper addDiscountMapper;
//
//    @Override
//    public List<AddDiscountDTO> createDiscount(List<AddDiscountDTO> addDiscountDTO) {
//        List<AddDiscountEntity> addDiscountEntities = addDiscountMapper.toEntityList(addDiscountDTO);
//        List<AddDiscountEntity> savedEntities = addDiscountRepository.saveAll(addDiscountEntities);
//        return addDiscountMapper.toDTOList(savedEntities);
//    }
//
//    @Override
//    public void deleteDiscount(int[] ids) {
//        for (int id : ids) {
//            addDiscountRepository.deleteById(id);
//        }
//    }
//}
