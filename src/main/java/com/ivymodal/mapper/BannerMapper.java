package com.ivymodal.mapper;

import com.ivymodal.dto.Banner.request.BannerRequest;
import com.ivymodal.dto.Banner.response.BannerResponse;
import com.ivymodal.entity.Banner;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper (componentModel = "spring")
public interface BannerMapper {
    Banner toBanner(BannerRequest request);

    BannerResponse toBannerResponse(Banner banner);

    List<BannerResponse> toBannerResponse(List<Banner> banners);

    void updateBanner(@MappingTarget Banner banner, BannerRequest request);

}
