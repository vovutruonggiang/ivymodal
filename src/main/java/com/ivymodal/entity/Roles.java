package com.ivymodal.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Entity
@Table(name = "roles")
public class Roles extends BaseEntity{
    String name;
    @OneToMany(mappedBy = "roles")
    List<Account> account;
}