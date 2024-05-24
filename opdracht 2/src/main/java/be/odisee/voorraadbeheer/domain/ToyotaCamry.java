package be.odisee.voorraadbeheer.domain;

public class ToyotaCamry extends Autosoort {
    /**
     * Responsibilities of the ToyotaCamry class
     * Inherits from Autosoort
     */
    // Fields for name and merk are no longer final
    private String name;
    private String merk;

    // Constructor initializes name, merk, huidigVoorraadniveau, minimumpeiler, and maximumpeiler fields
    public ToyotaCamry(String name, String merk, int huidigVoorraadniveau, int minimumpeiler, int maximumpeiler) {
        super(name, merk, huidigVoorraadniveau, minimumpeiler, maximumpeiler);
        // Additional initialization specific to ToyotaCamry can be done here if needed
    }
}
