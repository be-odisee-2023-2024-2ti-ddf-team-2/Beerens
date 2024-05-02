package be.odisee.voorraadbeheer.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AUTOSOORTEN")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force=true)
/**Verantwoordelijkheden van de abstracte klasse Autosoort*/
public abstract class Autosoort {
    @Id
    protected int id;
    protected String status = "Niet in bestelling";
    protected String naam;
    protected String merk;
    protected int huidigVoorraadniveau;
    protected int minimumpeiler;
    protected int maximumpeiler;
    // One-to-many relationship with AnalyseMarktvraag
    @OneToMany(mappedBy = "yourEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    protected List<AnalyseMarktvraag> marktvraag = new ArrayList<AnalyseMarktvraag>();
    // One-to-many relationship with Tip
    @OneToMany(mappedBy = "yourEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    protected List<Tip> tips = new ArrayList<Tip>();
    protected boolean verkooptSlecht = false;

    public Autosoort(String name, String merk, int huidigVoorraadniveau, int minimumpeiler, int maximumpeiler) {
    }

    /*
    public void registreerBestelling(int hoeveelheid) {
        // Telt het geleverde aantal auto’s op bij het voorraadniveau voor die autosoort.
        //huidigVoorraadniveau = huidigVoorraadniveau + hoeveelheid;
    }
    */

    /*
    public Verkoop registreerVerkoop(Date verkoopdatum, Autosoort autosoort, Factuur factuur, BeerensMedewerker verkoper, int hoeveelheid) {
        // Maakt een nieuwe verkoop, past het voorraadniveau aan en zet de status op niet slecht verkopend.
        Verkoop nieuweVerkoop = new Verkoop();
        this.verkooptSlecht = false;
        this.isVerkocht(hoeveelheid);
        return nieuweVerkoop;
    }
    */

    public void isVerkocht(int hoeveelheid) {
        /**
         * Vermindert het aantal auto’s in voorraad met het aantal verkochte auto’s.
         *
         * @param hoeveelheid De hoeveelheid verkochte auto's.
         * */
        //huidigVoorraadniveau = huidigVoorraadniveau - hoeveelheid;
    }

    public Tip voegTipToe(String tip) {
        /**
         * Voegt een tip toe aan de lijst van tips.
         *
         * @param tip De geschreven tip.
         * @return Het nieuwe Tip object.
         */
        Tip nieuweTip = new Tip(tip);
        tips.add(nieuweTip);
        return nieuweTip;
    }

    public AnalyseMarktvraag voegAnalyseMarktvraagToe(String analyse) {
        /**
         * Voegt een AnalyseMarktvraag toe aan de lijst van AnalyseMarktvraag.
         * Zet status van laatste AnalyseMarktvraag op "Vervangen".
         *
         * @param analyse De geschreven analyse van de marktvraag.
         * @return Het nieuwe AnalyseMarktvraag object.
         */
        AnalyseMarktvraag nieuweAnalyse = new AnalyseMarktvraag(analyse);

        if (!marktvraag.isEmpty()) {
            AnalyseMarktvraag laatsteAnalyse = marktvraag.get(marktvraag.size() - 1);
            laatsteAnalyse.vervangAnalyseMarktvraag();
        }

        marktvraag.add(nieuweAnalyse); // voeg toe aan lijst met tips
        return nieuweAnalyse;
    }

    public Bestelling voegBestellingToe(int hoeveelheid) {
        /**
         * Voegt een bestelling toe en zet de autosoort in bestelling.
         *
         * @param hoeveelheid De hoeveelheid autos te bestellen.
         * @return Het nieuwe Bestelling object.
         */
        Bestelling nieuweBestelling = new Bestelling(this, hoeveelheid);
        status = "In bestelling";
        return nieuweBestelling;
    }
    public void bestellingAfgerond() {
        /**
         * Verandert de status naar "Niet in bestelling"
         */
        status = "Niet in bestelling";
    }


    public void setVerkooptSlecht() {
        /** Duidt aan dat een autosoort slecht verkoopt */
        verkooptSlecht = true;
    }
}