package com.ivymodal.mapper;

import com.ivymodal.dto.ColorDTO;
import com.ivymodal.entity.ColorEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ColorMapper extends BaseConversion<ColorDTO, ColorEntity> {
       public ColorMapper() {
           super(ColorDTO.class, ColorEntity.class);
       }
}
