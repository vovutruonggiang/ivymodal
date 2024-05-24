package com.ivymodal.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {
     String name;
     String description;
     MultipartFile thumbnail;
     Long category;
     List<Double> price;
     List<Integer> stock;
     List<Long> color;
     List<Long> size;
     List<MultipartFile> image;
}
