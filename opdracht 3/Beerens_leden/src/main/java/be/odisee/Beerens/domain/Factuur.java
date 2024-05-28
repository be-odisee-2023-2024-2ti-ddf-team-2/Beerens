package be.odisee.Beerens.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Factuur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int bestellingId;
    private Date factuurdatum;
    private double bedrag;
    private boolean betaald;

    public Factuur() {
        // JPA vereist een no-argument constructor
    }

    public Factuur(int id, int bestellingId, Date factuurdatum, double bedrag, boolean betaald) {
        this.id = id;
        this.bestellingId = bestellingId;
        this.factuurdatum = factuurdatum;
        this.bedrag = bedrag;
        this.betaald = betaald;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getBestellingId() { return bestellingId; }
    public void setBestellingId(int bestellingId) { this.bestellingId = bestellingId; }
    public Date getFactuurdatum() { return factuurdatum; }
    public void setFactuurdatum(Date factuurdatum) { this.factuurdatum = factuurdatum; }
    public double getBedrag() { return bedrag; }
    public void setBedrag(double bedrag) { this.bedrag = bedrag; }
    public boolean isBetaald() { return betaald; }
    public void setBetaald(boolean betaald) { this.betaald = betaald; }

    @Override
    public String toString() {
        return "Factuur{" +
                "id=" + id +
                ", bestellingId=" + bestellingId +
                ", factuurdatum=" + factuurdatum +
                ", bedrag=" + bedrag +
                ", betaald=" + betaald +
                '}';
    }
}
