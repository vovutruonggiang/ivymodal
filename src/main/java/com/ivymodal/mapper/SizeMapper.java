package com.ivymodal.mapper;

import com.ivymodal.dto.SizeDTO;
import com.ivymodal.entity.SizeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SizeMapper {
    @Autowired
    private ModelMapper modelMapper;

    public SizeDTO toDTO(SizeEntity size) {
        return modelMapper.map(size, SizeDTO.class);
    }

    public SizeEntity toEntity(SizeDTO dto) {
        return modelMapper.map(dto, SizeEntity.class);
    }
}
