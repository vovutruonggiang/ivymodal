package com.ivymodal.mapper;

import com.ivymodal.dto.Size.request.SizeRequest;
import com.ivymodal.dto.Size.response.SizeResponse;
import com.ivymodal.entity.Size;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SizeMapper {
    Size toSize(SizeRequest request);

    SizeResponse toSizeResponse(Size size);

    void updateSize(@MappingTarget Size size, SizeRequest request);
}
