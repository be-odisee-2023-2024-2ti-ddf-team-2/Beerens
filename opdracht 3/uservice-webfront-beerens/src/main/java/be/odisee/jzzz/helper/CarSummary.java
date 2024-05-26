package be.odisee.jzzz.helper;

import java.util.Date;

/**
 * Helper klasse voor Car samenvattingen.
 */
public class CarSummary {
    private Long id;
    private String merk;
    private String model;
    private int bouwjaar;
    private String kenteken;
    private double dagtarief;
    private Date created;

    public CarSummary(String merk, String model, int bouwjaar, String kenteken, double dagtarief, Date created) {
        this.merk = merk;
        this.model = model;
        this.bouwjaar = bouwjaar;
        this.kenteken = kenteken;
        this.dagtarief = dagtarief;
        this.created = created;
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
}
