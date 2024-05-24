package com.ivymodal.service.impl;

import com.ivymodal.dto.SizeDTO;
import com.ivymodal.entity.SizeEntity;
import com.ivymodal.mapper.SizeMapper;
import com.ivymodal.repository.SizeRepository;
import com.ivymodal.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SizeService implements ISizeService {
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private SizeMapper sizeMapper;

    @Override
    public SizeDTO createSize(SizeDTO sizeDTO) {
        SizeEntity Size = sizeMapper.toEntity(sizeDTO);
        Size = sizeRepository.save(Size);
        return sizeMapper.toDTO(Size);
    }

    @Override
    public SizeDTO updateSize(int id, SizeDTO SizeDTO) {
        SizeEntity Size = sizeMapper.toEntity(SizeDTO);
        Size.setId(id);
        Size = sizeRepository.save(Size);
        return sizeMapper.toDTO(Size);
    }

    @Override
    public void deleteSize(int id) {
        sizeRepository.deleteById(id);
    }

    @Override
    public List<SizeDTO> getAllSizes() {
        List<SizeEntity> Size = sizeRepository.findAll();
        return Size.stream().map(sizeMapper::toDTO).collect(Collectors.toList());
    }
}
