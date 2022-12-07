package com.example.airportmanager.classes;

import java.io.Serializable;

public class Pilote implements Serializable {

    int ID;
    String nom;
    String prenom;
    int  age;
    int experience ;

    public Pilote() {
    }

    @Override
    public String toString() {
        return "Pilote{" +
                "ID=" + ID +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", experience=" + experience +
                '}';
    }

    public Pilote(int ID, String nom, String prenom, int age, int experience) {
        this.ID = ID;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.experience = experience;
    }

    public Pilote(String nom, String prenom, int age, int experience) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.experience = experience;
    }

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }


}
