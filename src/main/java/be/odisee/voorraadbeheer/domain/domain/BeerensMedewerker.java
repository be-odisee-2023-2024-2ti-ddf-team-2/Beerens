package be.odisee.voorraadbeheer.domain.domain;

public class BeerensMedewerker {
    /**Verantwoordelijkheden van de klasse BeerensMedewerker*/
    protected int id;
    protected String status = "In dienst";
    protected String voornaam;
    protected String achternaam;
    protected String email;
    protected String telefoonnummer;

    protected BeerensMedewerkerFunctie functie;

    public BeerensMedewerker() {}

    public BeerensMedewerker(String voornaam, String achternaam, String email, String telefoonnummer, BeerensMedewerkerFunctie functie) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.telefoonnummer = telefoonnummer;
        this.functie = functie;
    }

    public void ontsla() {
        /** Zet de status op "Niet meer in dienst" */
    }

    public void neemInDienst() {
        /** Zet de status op "Ontslagen" */
    }
}