package com.example.airportmanager.classes;

import java.io.Serializable;
import java.util.Date;

public class Vole implements Serializable {
    int ID;
    String depart;
    String destination;
    String date;
    String pilote;
    String avion;

    public Vole(int ID, String depart, String destination, String date, String pilote, String avion) {
        this.ID = ID;
        this.depart = depart;
        this.destination = destination;
        this.date = date;
        this.pilote = pilote;
        this.avion = avion;
    }

    public Vole() {}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPilote() {
        return pilote;
    }

    public void setPilote(String pilote) {
        this.pilote = pilote;
    }

    public String getAvion() {
        return avion;
    }

    public void setAvion(String avion) {
        this.avion = avion;
    }

    @Override
    public String toString() {
        return "Vole{" +
                "ID=" + ID +
                ", depart='" + depart + '\'' +
                ", destination='" + destination + '\'' +
                ", date=" + date +
                ", pilote=" + pilote +
                ", avion=" + avion +
                '}';
    }
}
