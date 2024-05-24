package com.ivymodal.dto;

import com.ivymodal.entity.BannerEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BannerDTO extends BaseDTO<BannerEntity> {
     String image;
     String url;
     Boolean status;
     String display_page;
}
