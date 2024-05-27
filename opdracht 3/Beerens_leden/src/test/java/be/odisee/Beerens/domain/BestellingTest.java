package be.odisee.Beerens.domain;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BestellingTest {
    @Test
    public void testBestellingCreation(){
        Date startdatum = new Date();
        Date einddatum = new Date();
        Bestelling bestelling = new Bestelling(1, 1, 1, startdatum, einddatum, 450.0);

        assertNotNull(bestelling);
        assertEquals(1, bestelling.getId());
        assertEquals(1, bestelling.getLidId());
        assertEquals(1, bestelling.getAutosoortId());
        assertEquals(startdatum, bestelling.getStartdatum());
        assertEquals(einddatum, bestelling.getEinddatum());
        assertEquals(450.0, bestelling.getTotaalprijs());
    }

    @Test
    public void testSettersAndGetters(){
        Bestelling bestelling = new Bestelling(1, 1, 1, new Date(), new Date(), 450.0);

        bestelling.setId(2);
        bestelling.setLidId(2);
        bestelling.setAutosoortId(2);
        Date newStartdatum = new Date();
        Date newEinddatum = new Date();
        bestelling.setStartdatum(newStartdatum);
        bestelling.setEinddatum(newEinddatum);
        bestelling.setTotaalprijs(550.0);

        assertEquals(2, bestelling.getId());
        assertEquals(2, bestelling.getLidId());
        assertEquals(2, bestelling.getAutosoortId());
        assertEquals(newStartdatum, bestelling.getStartdatum());
        assertEquals(newEinddatum, bestelling.getEinddatum());
        assertEquals(550.0, bestelling.getTotaalprijs());
    }
}