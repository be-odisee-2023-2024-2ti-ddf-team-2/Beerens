package be.odisee.Beerens.domain;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "facturen")
public class Factuur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private int bestellingId;
        private Date factuurdatum;
        private double bedrag;
        private boolean betaald;
    // Existing fields...


    // Existing constructor...
    public Factuur(int id, Date factuurdatum, double bedrag, boolean betaald) {
        // Initialization...
    }

    // New constructor...
    public Factuur(String factuurdatumString, int bedrag) {
        // Convert factuurdatumString to Date if needed...
        this.factuurdatum = convertStringToDate(factuurdatumString);
        this.bedrag = bedrag;
    }

    // Helper method to convert String to Date if needed...
    private Date convertStringToDate(String dateString) {
        // Logic to convert String to Date...
        // For example:
        // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // Date date = dateFormat.parse(dateString);
        // return date;
        // Please replace this example with your actual logic
        return null;
    }


        public Factuur(int id, int bestellingId, Date factuurdatum, double bedrag, boolean betaald) {
            this.id = id;
            this.bestellingId = bestellingId;
            this.factuurdatum = factuurdatum;
            this.bedrag = bedrag;
            this.betaald = betaald;
        }

    public Factuur() {

    }

    // Getters and Setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getBestellingId() {
            return bestellingId;
        }

        public void setBestellingId(int bestellingId) {
            this.bestellingId = bestellingId;
        }

        public Date getFactuurdatum() {
            return factuurdatum;
        }

        public void setFactuurdatum(Date factuurdatum) {
            this.factuurdatum = factuurdatum;
        }

        public double getBedrag() {
            return bedrag;
        }

        public void setBedrag(double bedrag) {
            this.bedrag = bedrag;
        }

        public boolean isBetaald() {
            return betaald;
        }

        public void setBetaald(boolean betaald) {
            this.betaald = betaald;
        }

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

