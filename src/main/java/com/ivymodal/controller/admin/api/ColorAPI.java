package com.ivymodal.controller.admin.api;

import com.ivymodal.dto.ColorDTO;
import com.ivymodal.service.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-admin-color")
public class ColorAPI {
    @Autowired
    private IColorService colorService;

    @PostMapping
    public ColorDTO createColor(@RequestBody ColorDTO colorDTO) {
        return colorService.createColor(colorDTO);
    }

    @PutMapping("/{id}")
    public ColorDTO updateColor(@PathVariable int id, @RequestBody ColorDTO colorDTO) {
        return colorService.updateColor(id, colorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteColor(@PathVariable int id) {
        colorService.deleteColor(id);
    }

    @GetMapping
    public List<ColorDTO> getAllColors() {
        return colorService.getAllColors();
    }
}
