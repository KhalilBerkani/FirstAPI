package com.ma.firstapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {

@Id()
@GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom ;
    private String telephone;
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    private List<Facture> factures;

}
