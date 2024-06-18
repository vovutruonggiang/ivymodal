package com.ivymodal.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "banner")
public class Banner extends BaseEntity{
     String image;
     String url;
     Boolean status;
     String display_page;
}
