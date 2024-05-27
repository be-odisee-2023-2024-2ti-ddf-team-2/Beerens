package be.odisee.jzzz.domain;

import java.util.Date;

public class Car {
    private Long id;
    private String merk;
    private String model;
    private int bouwjaar;
    private String kenteken;
    private double dagtarief;
    private Date created;
    private Date updated;

    public Car() {}

    public Car(String merk, String model, int bouwjaar, String kenteken, double dagtarief) {
        this.merk = merk;
        this.model = model;
        this.bouwjaar = bouwjaar;
        this.kenteken = kenteken;
        this.dagtarief = dagtarief;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
