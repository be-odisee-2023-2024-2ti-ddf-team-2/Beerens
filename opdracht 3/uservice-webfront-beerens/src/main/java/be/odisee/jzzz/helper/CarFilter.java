package be.odisee.jzzz.helper;

/**
 * Helper klasse voor het filteren van auto's.
 */
public class CarFilter {
    private String merk;
    private String model;

    public CarFilter() {}

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
}
