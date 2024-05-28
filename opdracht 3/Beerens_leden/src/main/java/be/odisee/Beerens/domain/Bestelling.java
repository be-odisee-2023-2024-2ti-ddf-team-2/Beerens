package be.odisee.Beerens.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Bestelling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int lidId;
    private int autosoortId;
    private Date startdatum;
    private Date einddatum;
    private double totaalprijs;

    public Bestelling(int id, int lidId, int autosoortId, Date startdatum, Date einddatum, double totaalprijs){
        this.id = id;
        this.lidId = lidId;
        this.autosoortId = autosoortId;
        this.startdatum = startdatum;
        this.einddatum = einddatum;
        this.totaalprijs = totaalprijs;
    }

    public Bestelling() {

    }
    //Getters and Setters

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getLidId(){
        return lidId;
    }
    public void setLidId(int lidId){
        this.lidId = lidId;
    }
    public int getAutosoortId(){
        return autosoortId;
    }
    public void setAutosoortId(int autosoortId) {
        this.autosoortId = autosoortId;
    }

    public Date getStartdatum() {
        return startdatum;
    }

    public void setStartdatum(Date startdatum) {
        this.startdatum = startdatum;
    }

    public Date getEinddatum() {
        return einddatum;
    }

    public void setEinddatum(Date einddatum) {
        this.einddatum = einddatum;
    }

    public double getTotaalprijs() {
        return totaalprijs;
    }

    public void setTotaalprijs(double totaalprijs) {
        this.totaalprijs = totaalprijs;
    }

    @Override
    public String toString(){
        return "Bestelling{" +
                "id=" + id +
                ", lidId=" + lidId +
                ", autosoortId=" +autosoortId +
                ", startdatum=" + startdatum +
                ", einddatum=" + einddatum +
                ", totaalprijs=" + totaalprijs +
                '}';
    }
}
