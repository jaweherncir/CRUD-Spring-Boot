package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

import java.io.Serializable;
@Entity
@Table(name="profiles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfile implements Serializable {
    @Id
    @GeneratedValue
    private  Integer Id ;

    private String avatar;
    private String telephone;
    @OneToOne
    @JoinColumn(name="user_id")
    private  UserEntity user;
}
