package com.ma.firstapi.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Data
@ToString
@Table(name = "ligne_facture")
public class LigneFacture implements Serializable {


    @EmbeddedId()
    private LigneFactureKey id;

    @ManyToOne()
    @MapsId("factureId")
    @JoinColumn(name="facture_id")
    private Facture facture;

    @ManyToOne()
    @MapsId("produitId")
    @JoinColumn(name="produit_id")
    private Produit produit ;


    private double quantite;


}
