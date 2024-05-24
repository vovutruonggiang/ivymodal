package com.ivymodal.service;

import com.ivymodal.dto.BannerDTO;
import com.ivymodal.entity.BannerEntity;

import java.util.List;

public interface IBannerService {
    BannerDTO save(BannerDTO bannerDTO);
    BannerDTO update(int id, BannerDTO bannerDTO);
    void delete(int id);
    List<BannerDTO> findAll();
}
