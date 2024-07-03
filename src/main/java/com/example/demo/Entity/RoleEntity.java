package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "roles")
public class RoleEntity implements Serializable {
    @Id
    private Integer roleId;
    @Column(nullable = false)
    private String name;
    @ManyToMany()
    @JoinTable(name="users_roles",joinColumns=@JoinColumn(name="roleId"),
            inverseJoinColumns =@JoinColumn(name = "userId")
    )
    private List<UserEntity> users;

}
