package com.example.airportmanager.classes;

import java.io.Serializable;

public class Avion implements Serializable {
    int ID;
    String nom;
    int capacite;
    String  entreprise;

    public Avion(int ID, String nom, int capacite, String entreprise) {
        this.ID = ID;
        this.nom = nom;
        this.capacite = capacite;
        this.entreprise = entreprise;
    }
    public Avion() {}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "ID=" + ID +
                ", nom='" + nom + '\'' +
                ", capacite=" + capacite +
                ", entreprise='" + entreprise + '\'' +
                '}';
    }
}
