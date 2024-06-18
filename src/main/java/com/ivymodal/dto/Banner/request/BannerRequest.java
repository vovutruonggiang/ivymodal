package com.ivymodal.dto.Banner.request;

import com.ivymodal.dto.BaseDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BannerRequest{
    String image;
    String url;
    Boolean status;
    String display_page;
}
