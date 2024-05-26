package com.ivymodal.mapper;

import com.ivymodal.dto.SizeDTO;
import com.ivymodal.entity.SizeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SizeMapper extends BaseConversion<SizeDTO,SizeEntity> {
    public SizeMapper() {
        super(SizeDTO.class, SizeEntity.class);
    }
}
