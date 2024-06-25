package com.ivymodal.service.admin.impl;

import com.ivymodal.dto.Size.request.SizeRequest;
import com.ivymodal.dto.Size.response.SizeResponse;
import com.ivymodal.entity.Size;
import com.ivymodal.exception.AppException;
import com.ivymodal.exception.ErrorCode;
import com.ivymodal.mapper.SizeMapper;
import com.ivymodal.repository.SizeRepository;
import com.ivymodal.service.admin.ISizeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SizeService implements ISizeService {

    SizeRepository sizeRepository;
    SizeMapper sizeMapper;

    @Override
    public List<SizeResponse> getAllSizes() {
        return sizeRepository.findAll()
                .stream()
                .map(sizeMapper::toSizeResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SizeResponse getOneSize(String sizeId) {
        return sizeMapper.toSizeResponse(sizeRepository.findById(sizeId).orElseThrow(() -> new AppException(ErrorCode.SIZE_NOT_FOUND)));
    }

    @Override
    public SizeResponse createSize(SizeRequest request) {
        if (sizeRepository.existsByName(request.getName()))
            throw new AppException(ErrorCode.SIZE_EXISTED);
        Size size = sizeMapper.toSize(request);
        return sizeMapper.toSizeResponse(sizeRepository.save(size));
    }

    @Override
    public SizeResponse updateSize(String sizeId, SizeRequest request) {
        Size size = sizeRepository.findById(sizeId).orElseThrow(() -> new AppException(ErrorCode.SIZE_NOT_FOUND));
        sizeMapper.updateSize(size,request);
        return sizeMapper.toSizeResponse(sizeRepository.save(size));
    }

    @Override
    public void deleteSize(String[] sizeId) {
        for (String size :sizeId){
            sizeRepository.deleteById(size);
        }
    }
}
