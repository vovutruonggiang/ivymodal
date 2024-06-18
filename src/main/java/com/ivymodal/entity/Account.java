package com.ivymodal.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults (level = AccessLevel.PRIVATE)
@Data
@Entity
@Table(name = "account")
public class Account extends BaseEntity {
    String username;
    String password;
    String email;

    @ManyToOne
    @JoinColumn(name = "id_roles")
    Roles roles;
}
