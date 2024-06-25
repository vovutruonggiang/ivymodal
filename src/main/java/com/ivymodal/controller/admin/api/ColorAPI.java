package com.ivymodal.controller.admin.api;

import com.ivymodal.dto.ApiResponse;
import com.ivymodal.dto.Category.response.CategoryResponse;
import com.ivymodal.dto.Color.request.ColorDeleteRequest;
import com.ivymodal.dto.Color.request.ColorRequest;
import com.ivymodal.dto.Color.response.ColorResponse;
import com.ivymodal.service.admin.IColorService;
import com.ivymodal.service.admin.impl.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-admin-color")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ColorAPI {

    IColorService colorService;
    private final CategoryService categoryService;

    @GetMapping
    public ApiResponse<List<ColorResponse>> getAllColors() {
        ApiResponse<List<ColorResponse>> apiResponse = new ApiResponse();
        apiResponse.setResult(colorService.getAllColors());
        return apiResponse;
    }

    @GetMapping("/{colorId}")
    public ApiResponse<CategoryResponse> getOneColor(@RequestParam("colorId") String colorId) {
        ApiResponse<CategoryResponse> apiResponse = new ApiResponse();
        apiResponse.setResult(categoryService.getOneCategory(colorId));
        return apiResponse;
    }

    @PostMapping
    public ApiResponse<ColorResponse> createColor(@RequestBody ColorRequest request) {
        ApiResponse<ColorResponse> apiResponse = new ApiResponse();
        apiResponse.setResult(colorService.createColor(request));
        return apiResponse;
    }

    @PutMapping("/{colorId}")
    public ApiResponse<ColorResponse> updateColor(@PathVariable String colorId, @RequestBody ColorRequest request) {
        ApiResponse<ColorResponse> apiResponse = new ApiResponse();
        apiResponse.setResult(colorService.updateColor(colorId,request));
        return apiResponse;
    }

    @DeleteMapping
    public ApiResponse<ColorResponse> deleteColor(@RequestBody ColorDeleteRequest request) {
        ApiResponse<ColorResponse> apiResponse = new ApiResponse();
        colorService.deleteColor(request.getIds());
        apiResponse.setResult(null);
        apiResponse.setMessage("delete success");
        return apiResponse;
    }
}
