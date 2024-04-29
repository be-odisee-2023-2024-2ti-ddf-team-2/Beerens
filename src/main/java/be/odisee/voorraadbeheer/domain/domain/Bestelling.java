package be.odisee.voorraadbeheer.domain.domain;

import java.util.Date;

public class Bestelling {
    /**Verantwoordelijkheden van de klasse Bestelling*/
    protected int id;
    protected String status = "In afwachting";
    protected Autosoort autosoort;
    protected int hoeveelheid;
    protected final Date besteldatum = new Date();
    protected Factuur factuur;
    protected Date verwachteLeveradatum;

    public Bestelling() {}

    public Bestelling(Autosoort autosoort, int hoeveelheid) {
        this.autosoort = autosoort;
        this.hoeveelheid = hoeveelheid;
    }

    public void annuleer() {
        /** Verwijdert de bestelling */

    }

    public void bestel() {
        /** Zet de status van bestelling op 'Besteld' */
        status = "Besteld";
    }

    public void isGeleverd() {
        /** Zet de status van bestelling op 'Geleverd' */
        status = "Geleverd";
        this.autosoort.registreerBestelling(this.hoeveelheid);
    }
}
