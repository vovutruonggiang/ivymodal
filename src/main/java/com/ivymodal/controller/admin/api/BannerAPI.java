package com.ivymodal.controller.admin.api;

import com.ivymodal.dto.ApiResponse;
import com.ivymodal.dto.Banner.request.BannerDeleteRequest;
import com.ivymodal.dto.Banner.request.BannerRequest;
import com.ivymodal.dto.Banner.response.BannerResponse;
import com.ivymodal.service.admin.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-admin-banner")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class BannerAPI {
    @Autowired
    private IBannerService bannerService;

    @PostMapping
    public ApiResponse<BannerResponse> createBanner(@RequestBody BannerRequest request) {
        ApiResponse<BannerResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(bannerService.createBanner(request));
        return apiResponse;
    }

    @PutMapping("/{bannerId}")
    public ApiResponse<BannerResponse> updateBanner(@PathVariable String bannerId, @RequestBody BannerRequest request) {
        ApiResponse<BannerResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(bannerService.updateBanner(bannerId,request));
        return apiResponse;
    }

    @DeleteMapping
    public ApiResponse<BannerResponse> deleteBanner(@RequestBody BannerDeleteRequest request) {
        ApiResponse<BannerResponse> apiResponse = new ApiResponse<>();
        bannerService.deleteBanner(request.getBannerIds());
        apiResponse.setMessage("Delete banner success");
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<BannerResponse>>getAllBanners() {
        ApiResponse<List<BannerResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(bannerService.findAllBanner());
        return apiResponse;
    }

    @GetMapping("{bannerId}")
    public ApiResponse<BannerResponse> getOneBanner(@PathVariable String bannerId) {
        ApiResponse<BannerResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(bannerService.findOneBanner(bannerId));
        return apiResponse;
    }

}
