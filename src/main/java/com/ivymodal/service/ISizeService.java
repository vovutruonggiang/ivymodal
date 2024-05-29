package com.ivymodal.service;
import com.ivymodal.dto.Size.request.SizeRequest;
import com.ivymodal.dto.Size.response.SizeResponse;

import java.util.List;

public interface ISizeService {
    List<SizeResponse> getAllSizes();
    SizeResponse getOneSize(String sizeId);
    SizeResponse createSize(SizeRequest request);
    SizeResponse updateSize(String sizeId, SizeRequest request);
    void deleteSize(String[] sizeId);

}
