package com.ivymodal.controller.admin.api;

import com.ivymodal.dto.ApiResponse;
import com.ivymodal.dto.Size.request.SizeDeleteRequest;
import com.ivymodal.dto.Size.request.SizeRequest;
import com.ivymodal.dto.Size.response.SizeResponse;
import com.ivymodal.service.admin.ISizeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-admin-size")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SizeAPI {

    ISizeService sizeService;

    @GetMapping
    public ApiResponse<List<SizeResponse>> getAllSizes(){
        ApiResponse<List<SizeResponse>> sizeResponse = new ApiResponse<>();
        sizeResponse.setResult(sizeService.getAllSizes());
        return sizeResponse;
    }

    @GetMapping("/{sizeId}")
    public ApiResponse<SizeResponse> getOneSize(@PathVariable String sizeId){
        ApiResponse<SizeResponse> sizeResponse = new ApiResponse<>();
        sizeResponse.setResult(sizeService.getOneSize(sizeId));
        return sizeResponse;
    }

    @PostMapping
    public ApiResponse<SizeResponse> createSize(@RequestBody SizeRequest request){
        ApiResponse<SizeResponse> sizeResponse = new ApiResponse<>();
        sizeResponse.setResult(sizeService.createSize(request));
        return sizeResponse;
    }

    @PutMapping("/{sizeId}")
    public ApiResponse<SizeResponse> updateSize(@RequestBody SizeRequest request,@PathVariable String sizeId){
        ApiResponse<SizeResponse> sizeResponse = new ApiResponse<>();
        sizeResponse.setResult(sizeService.updateSize(sizeId,request));
        return sizeResponse;
    }

    @DeleteMapping
    public ApiResponse<SizeResponse> deleteSize(@RequestBody SizeDeleteRequest request){
        ApiResponse<SizeResponse> apiResponse = new ApiResponse<>();
        sizeService.deleteSize(request.getIds());
        apiResponse.setResult(null);
        apiResponse.setMessage("delete success");
        return apiResponse;
    }
}
