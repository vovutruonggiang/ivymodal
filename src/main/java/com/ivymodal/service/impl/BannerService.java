package com.ivymodal.service.impl;

import com.ivymodal.dto.BannerDTO;
import com.ivymodal.entity.BannerEntity;
import com.ivymodal.mapper.BannerMapper;
import com.ivymodal.mapper.BaseConversion;
import com.ivymodal.repository.BannerRepository;
import com.ivymodal.service.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BannerService implements IBannerService {
    @Autowired
    private BannerRepository bannerRepository;

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public BannerDTO save(BannerDTO bannerDTO) {
        BannerEntity banner = bannerMapper.toEntity(bannerDTO);
        banner = bannerRepository.save(banner);
        return bannerMapper.toDTO(banner);
    }

    @Override
    public BannerDTO update(int id, BannerDTO bannerDTO) {
        BannerEntity banner = bannerMapper.toEntity(bannerDTO);
        banner.setId(id);
        bannerRepository.save(banner);
        return bannerMapper.toDTO(banner);
    }

    @Override
    public void delete(int id) {
        BannerEntity banner = bannerRepository.findById(id).get();
        bannerRepository.delete(banner);
    }

    @Override
    public List<BannerDTO> findAll() {
        List<BannerEntity> listBanner = bannerRepository.findAll();
        return listBanner.stream()
                .map(bannerMapper::toDTO)
                .collect(Collectors.toList());
    }


}
