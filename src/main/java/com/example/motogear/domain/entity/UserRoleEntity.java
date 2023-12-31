package com.example.motogear.domain.entity;

import com.example.motogear.domain.enums.UserRoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity{

    @Column
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;


    public UserRoleEntity() {
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public UserRoleEntity setRole(UserRoleEnum role) {
        this.role = role;
        return this;
    }
}
