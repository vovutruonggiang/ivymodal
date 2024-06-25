package com.ivymodal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Entity
@Table(name = "admin_users")
public class AdminUsers extends BaseEntity{
    String username;
    String password;
    String fullname;

    @ManyToOne
    @JoinColumn(name = "id_roles")
    private Roles roles;
}
