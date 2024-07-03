package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="factures")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FactureEntity  implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String ref;
    @Column(nullable = false,name="date_creation_facture")
    private Date date;
    @ManyToOne
    private ClientEntity client;
    @OneToMany(mappedBy = "facture",fetch =FetchType.LAZY,cascade = CascadeType.ALL)
    private List<LigneFactureEntity> ligneFactures;
}
