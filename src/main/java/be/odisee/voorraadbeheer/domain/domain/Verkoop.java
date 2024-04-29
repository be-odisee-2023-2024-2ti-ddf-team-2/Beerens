package be.odisee.voorraadbeheer.domain.domain;

import be.odisee.voorraadbeheer.domain.domain.Autosoort;
import be.odisee.voorraadbeheer.domain.domain.BeerensMedewerker;
import be.odisee.voorraadbeheer.domain.domain.Factuur;

import java.util.Date;

public class Verkoop {
    /**Verantwoordelijkheden van de klasse Verkoop*/
    protected int id;
    protected String status = "Niet geregistreerd";
    protected Date verkoopdatum;
    protected Autosoort autosoort;
    protected Factuur factuur;
    protected BeerensMedewerker verkoper;

    protected int hoeveelheid;

    public Verkoop() {}

    public Verkoop(Date verkoopdatum, Autosoort autosoort, Factuur factuur, BeerensMedewerker verkoper, int hoeveelheid) {
        this.verkoopdatum = verkoopdatum;
        this.autosoort = autosoort;
        this.factuur = factuur;
        this.verkoper = verkoper;
        this.hoeveelheid = hoeveelheid;
    }

    public void annuleerVerkoop() {
        /** Verwijdert de verkoop */
    }
}
