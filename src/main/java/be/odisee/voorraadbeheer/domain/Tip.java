package be.odisee.voorraadbeheer.domain;

import java.time.LocalDate;
import java.util.Date;

public class Tip {
    /**Verantwoordelijkheden van de klasse Tip*/
    protected int id;
    protected String status = "Ongebruikt";
    protected final Date datum = new Date();
    protected String beschrijving;

    public Tip() {}

    public Tip(String beschrijving) {
        this.beschrijving = beschrijving;
    }
}
