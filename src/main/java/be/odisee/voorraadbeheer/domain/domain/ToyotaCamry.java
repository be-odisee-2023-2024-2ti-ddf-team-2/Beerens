package be.odisee.voorraadbeheer.domain.domain;

import be.odisee.voorraadbeheer.domain.domain.Autosoort;

public class ToyotaCamry extends Autosoort {
    /**
     * Verantwoordelijkheden van de klasse ToyotaCamry
     * Erft over van Autosoort
     * */
    // Fields for name and merk are declared final
    private final String name;
    private final String merk;

    // Constructor initializes name and merk fields
    public ToyotaCamry(String name, String merk, int huidigVoorraadniveau, int minimumpeiler, int maximumpeiler) {
        super(name, merk, huidigVoorraadniveau, minimumpeiler, maximumpeiler);
        this.name = name;
        this.merk = merk;
        this.huidigVoorraadniveau = huidigVoorraadniveau;
        this.minimumpeiler = minimumpeiler;
        this.maximumpeiler = maximumpeiler;
    }
}
