package com.ivymodal.controller.admin.api;

import com.ivymodal.dto.SizeDTO;
import com.ivymodal.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-admin-size")
public class SizeAPI {
    @Autowired
    private ISizeService SizeService;

    @PostMapping
    public SizeDTO createSize(@RequestBody SizeDTO SizeDTO) {
        return SizeService.createSize(SizeDTO);
    }

    @PutMapping("/{id}")
    public SizeDTO updateSize(@PathVariable int id, @RequestBody SizeDTO SizeDTO) {
        return SizeService.updateSize(id, SizeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSize(@PathVariable int id) {
        SizeService.deleteSize(id);
    }

    @GetMapping
    public List<SizeDTO> getAllSizes() {
        return SizeService.getAllSizes();
    }
}
