package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="produits")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProduitEntity implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String ref_pro;
    @Column(nullable = false)
    private float prix_unitaire;
    @Column(nullable = false)
    private Integer quantite_stock;
    @OneToMany(mappedBy = "produit",fetch =FetchType.LAZY,cascade = CascadeType.ALL)
    private List<LigneFactureEntity> ligneFacture;
}
