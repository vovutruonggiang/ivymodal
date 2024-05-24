package com.ivymodal.mapper;

import com.ivymodal.dto.ColorDTO;
import com.ivymodal.entity.ColorEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ColorMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ColorDTO toDTO(ColorEntity color) {
        return modelMapper.map(color, ColorDTO.class);
    }

    public ColorEntity toEntity(ColorDTO dto) {
        return modelMapper.map(dto, ColorEntity.class);
    }
}
