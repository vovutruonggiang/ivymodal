package com.ivymodal.service.admin;

import com.ivymodal.dto.Banner.request.BannerRequest;
import com.ivymodal.dto.Banner.response.BannerResponse;

import java.util.List;

public interface IBannerService {
    BannerResponse createBanner(BannerRequest request);
    BannerResponse updateBanner(String bannerId, BannerRequest request);
    void deleteBanner(String[] bannerId);
    List<BannerResponse> findAllBanner();
    BannerResponse findOneBanner(String bannerId);
}
