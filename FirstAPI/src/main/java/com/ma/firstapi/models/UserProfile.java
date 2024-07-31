package com.ma.firstapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name= "profiles")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserProfile implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String avatar;
    private String telephone;

    @OneToOne
    @JoinColumn(name ="user_id")
    private User user;


}
