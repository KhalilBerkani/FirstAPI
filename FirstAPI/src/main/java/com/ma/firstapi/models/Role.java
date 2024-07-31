package com.ma.firstapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="roles")
public class Role implements Serializable {
    @Id
    private Integer id;
    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name="user_roles",joinColumns = @JoinColumn(name="roleId"),
            inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private List<User> users;
}
