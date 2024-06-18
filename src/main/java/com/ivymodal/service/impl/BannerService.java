package com.ivymodal.service.impl;

import com.ivymodal.dto.Banner.request.BannerRequest;
import com.ivymodal.dto.Banner.response.BannerResponse;
import com.ivymodal.entity.Banner;
import com.ivymodal.exception.AppException;
import com.ivymodal.exception.ErrorCode;
import com.ivymodal.mapper.BannerMapper;
import com.ivymodal.repository.BannerRepository;
import com.ivymodal.service.IBannerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BannerService implements IBannerService {
    BannerRepository bannerRepository;
    BannerMapper bannerMapper;

    @Override
    public BannerResponse createBanner(BannerRequest request) {
        return bannerMapper.toBannerResponse(bannerRepository.save(bannerMapper.toBanner(request)));
    }

    @Override
    public BannerResponse updateBanner(String bannerId, BannerRequest request) {
        Banner banner = bannerRepository.findById(bannerId)
                .orElseThrow(() -> new AppException(ErrorCode.BANNER_NOT_FOUND));
        bannerMapper.updateBanner(banner, request);
        return bannerMapper.toBannerResponse(bannerRepository.save(banner));
    }

    @Override
    public void deleteBanner(String[] bannerId) {
        for (String banner : bannerId) {
            bannerRepository.deleteById(banner);
        }
    }

    @Override
    public List<BannerResponse> findAllBanner() {
        return bannerMapper.toBannerResponse(bannerRepository.findAll());
    }

    @Override
    public BannerResponse findOneBanner(String bannerId) {
        Banner banner = bannerRepository.findById(bannerId)
                .orElseThrow(() -> new AppException(ErrorCode.BANNER_NOT_FOUND));
        return bannerMapper.toBannerResponse(banner);
    }
}
