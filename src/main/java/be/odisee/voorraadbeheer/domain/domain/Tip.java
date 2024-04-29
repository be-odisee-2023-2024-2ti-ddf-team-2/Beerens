package be.odisee.voorraadbeheer.domain.domain;

import java.time.LocalDate;
import java.util.Date;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORIES")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE,force=true)
public class Tip {
    /**Verantwoordelijkheden van de klasse Tip*/
    @Id
    private int id;
    protected String status = "Ongebruikt";
    protected final Date datum = new Date();
    protected String beschrijving;

    public Tip(String beschrijving) {
        this.beschrijving = beschrijving;
    }
}
