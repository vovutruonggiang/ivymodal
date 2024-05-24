package com.ivymodal.service;

import com.ivymodal.dto.ColorDTO;

import java.util.List;

public interface IColorService {
    ColorDTO createColor(ColorDTO colorDTO);
    ColorDTO updateColor(int id, ColorDTO colorDTO);
    void deleteColor(int id);
    List<ColorDTO> getAllColors();
}
