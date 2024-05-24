package com.ivymodal.mapper;

import com.ivymodal.dto.BannerDTO;
import com.ivymodal.entity.BannerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BannerMapper {
    @Autowired
    private ModelMapper modelMapper;

    public BannerDTO toDTO(BannerEntity banner) {
        return modelMapper.map(banner, BannerDTO.class);
    }

    public BannerEntity toEntity(BannerDTO dto) {
        return modelMapper.map(dto, BannerEntity.class);
    }

}
