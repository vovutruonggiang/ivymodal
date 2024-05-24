package com.ivymodal.service.impl;

import com.ivymodal.dto.ColorDTO;
import com.ivymodal.entity.ColorEntity;
import com.ivymodal.mapper.ColorMapper;
import com.ivymodal.repository.ColorRepository;
import com.ivymodal.service.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColorService implements IColorService {
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private ColorMapper colorMapper;

    @Override
    public ColorDTO createColor(ColorDTO colorDTO) {
        ColorEntity color = colorMapper.toEntity(colorDTO);
        color = colorRepository.save(color);
        return colorMapper.toDTO(color);
    }

    @Override
    public ColorDTO updateColor(int id, ColorDTO colorDTO) {
        ColorEntity color = colorMapper.toEntity(colorDTO);
        color.setId(id);
        color = colorRepository.save(color);
        return colorMapper.toDTO(color);
    }

    @Override
    public void deleteColor(int id) {
        colorRepository.deleteById(id);
    }

    @Override
    public List<ColorDTO> getAllColors() {
        List<ColorEntity> color = colorRepository.findAll();
        return color.stream().map(colorMapper::toDTO).collect(Collectors.toList());
    }
}
