package com.ivymodal.service.admin.impl;

import com.ivymodal.dto.Color.request.ColorRequest;
import com.ivymodal.dto.Color.response.ColorResponse;
import com.ivymodal.entity.Color;
import com.ivymodal.exception.AppException;
import com.ivymodal.exception.ErrorCode;
import com.ivymodal.mapper.ColorMapper;
import com.ivymodal.repository.ColorRepository;
import com.ivymodal.service.admin.IColorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ColorService implements IColorService {
    ColorRepository colorRepository;
    ColorMapper colorMapper;

    @Override
    public List<ColorResponse> getAllColors() {
        return colorRepository.findAll()
                .stream()
                .map(colorMapper::toColorResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ColorResponse getOneColor(String colorId) {
        return colorMapper.toColorResponse(colorRepository.findById(colorId)
                        .orElseThrow(()-> new AppException(ErrorCode.COLOR_NOT_FOUND)));
    }

    @Override
    public ColorResponse createColor(ColorRequest request) {
        if(colorRepository.existsByName(request.getName()))
            throw new AppException(ErrorCode.COLOR_EXISTED);
        Color color = colorMapper.toColor(request);
        return colorMapper.toColorResponse(colorRepository.save(color));
    }

    @Override
    public ColorResponse updateColor(String colorId, ColorRequest request) {
        Color color = colorRepository.findById(colorId)
                .orElseThrow(()-> new AppException(ErrorCode.COLOR_NOT_FOUND));
        colorMapper.updateColor(color,request);
        return colorMapper.toColorResponse(colorRepository.save(color));
    }

    @Override
    public void deleteColor(String[] colorId) {
        for(String color:colorId){
            colorRepository.deleteById(color);
        }
    }

}
