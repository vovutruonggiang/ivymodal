package com.ivymodal.controller.admin.api;

import com.ivymodal.dto.BannerDTO;
import com.ivymodal.entity.BannerEntity;
import com.ivymodal.mapper.BannerMapper;
import com.ivymodal.service.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/api-admin-banner")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class BannerAPI {
    @Autowired
    private IBannerService bannerService;

    @Autowired
    private BannerMapper bannerMapper;

    @PostMapping
    public BannerDTO createBanner(@RequestBody BannerDTO bannerDTO) {
        return bannerService.save(bannerDTO);
    }

    @PutMapping("/{id}")
    public BannerDTO updateBanner(@PathVariable int id, @RequestBody BannerDTO bannerDTO) {
        return bannerService.update(id, bannerDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBanner(@PathVariable int id) {
        try {
            bannerService.delete(id);
            return new ResponseEntity<>("Banner deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Banner deleted error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public List<BannerDTO> getAllBanners() {
        return bannerService.findAll();
    }

}
