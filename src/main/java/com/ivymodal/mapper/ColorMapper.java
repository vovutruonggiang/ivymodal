package com.ivymodal.mapper;

import com.ivymodal.dto.Color.request.ColorRequest;
import com.ivymodal.dto.Color.response.ColorResponse;
import com.ivymodal.entity.Color;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface ColorMapper {
   Color toColor(ColorRequest request);

   ColorResponse toColorResponse(Color color);

   void updateColor(@MappingTarget Color color , ColorRequest colorRequest);
}
