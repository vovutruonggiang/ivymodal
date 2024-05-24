package com.ivymodal.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "banner")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BannerEntity extends BaseEntity{
     String image;
     String url;
     Boolean status;
     String display_page;
}
