package com.salma.don_Donnateur.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Don {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double montant;
    private LocalDate date;


    @ManyToOne
    @JoinColumn(name = "donateur_id")
    private Donateur donateur;

    @ManyToOne
    @JoinColumn(name = "campagne_id")
    private Campagne campagne;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Campagne getCampagne() {
        return campagne;
    }

    public void setCampagne(Campagne campagne) {
        this.campagne = campagne;
    }

    public Donateur getDonateur() {
        return donateur;
    }

    public void setDonateur(Donateur donateur) {
        this.donateur = donateur;
    }

}