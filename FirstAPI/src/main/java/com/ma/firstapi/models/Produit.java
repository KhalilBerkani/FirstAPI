package com.ma.firstapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name="produits")
@AllArgsConstructor
@NoArgsConstructor
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = false)
    private String reference;

    @Column(nullable = false)
    private BigDecimal prix;

    @Column(nullable = false)
    private double quantite_stock;

    @OneToMany(mappedBy = "produit")
    private List<LigneFacture> ligneFacture;
}
