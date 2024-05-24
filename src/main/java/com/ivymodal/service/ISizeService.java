package com.ivymodal.service;
import com.ivymodal.dto.SizeDTO;

import java.util.List;

public interface ISizeService {
    SizeDTO createSize(SizeDTO sizeDTO);
    SizeDTO updateSize(int id, SizeDTO sizeDTO);
    void deleteSize(int id);
    List<SizeDTO> getAllSizes();
}
