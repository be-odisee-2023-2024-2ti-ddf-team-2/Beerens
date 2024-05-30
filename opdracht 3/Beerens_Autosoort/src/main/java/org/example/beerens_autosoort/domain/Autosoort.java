package org.example.beerens_autosoort.domain;

import jakarta.persistence.*;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name="autosoorten")
public class Autosoort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String merk;
    private String model;
    private int bouwjaar;
    private String kenteken;
    private double dagtarief;

    public Autosoort() {
    }

    public Autosoort(String merk, String model, int bouwjaar, String kenteken, double dagtarief) {
        this.merk = merk;
        this.model = model;
        this.bouwjaar = bouwjaar;
        this.kenteken = kenteken;
        this.dagtarief = dagtarief;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBouwjaar() {
        return bouwjaar;
    }

    public void setBouwjaar(int bouwjaar) {
        this.bouwjaar = bouwjaar;
    }

    public String getKenteken() {
        return kenteken;
    }

    public void setKenteken(String kenteken) {
        this.kenteken = kenteken;
    }

    public double getDagtarief() {
        return dagtarief;
    }

    public void setDagtarief(double dagtarief) {
        this.dagtarief = dagtarief;
    }
}