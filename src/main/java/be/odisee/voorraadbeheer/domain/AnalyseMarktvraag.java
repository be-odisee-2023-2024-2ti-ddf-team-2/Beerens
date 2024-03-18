package be.odisee.voorraadbeheer.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/** Verantwoordelijkheden van de klasse AnalyseMarktvraag*/
public class AnalyseMarktvraag {
    protected int id;
    protected String status = "Actueel";
    protected final Date datum = new Date();
    protected List<Tip> tips = new ArrayList<Tip>();
    protected String beschrijving;

    public AnalyseMarktvraag() {}

    public AnalyseMarktvraag(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public AnalyseMarktvraag(List<Tip> tips, String beschrijving) {
        this.tips = tips;
        this.beschrijving = beschrijving;
    }

    public void vervangAnalyseMarktvraag() {
        /** update status naar vervangen wanneer een nieuwe analyse gemaakt wordt */
        status = "Vervangen";
    }
}
