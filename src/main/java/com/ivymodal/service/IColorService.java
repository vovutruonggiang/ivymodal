package com.ivymodal.service;

import com.ivymodal.dto.Color.request.ColorRequest;
import com.ivymodal.dto.Color.response.ColorResponse;

import java.util.List;

public interface IColorService {
    List<ColorResponse> getAllColors();
    ColorResponse getOneColor(String colorId);
    ColorResponse createColor(ColorRequest request);
    ColorResponse updateColor(String colorId, ColorRequest request);
    void deleteColor(String[] colorId);
}
