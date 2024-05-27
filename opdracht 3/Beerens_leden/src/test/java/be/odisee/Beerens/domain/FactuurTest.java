package be.odisee.Beerens.domain;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FactuurTest {

    @Test
    public void testFactuurCreation() {
        Date factuurdatum = new Date();
        Factuur factuur = new Factuur(1, 1, factuurdatum, 450.0, true);

        assertNotNull(factuur);
        assertEquals(1, factuur.getId());
        assertEquals(1, factuur.getBestellingId());
        assertEquals(factuurdatum, factuur.getFactuurdatum());
        assertEquals(450.0, factuur.getBedrag());
        assertTrue(factuur.isBetaald());
    }

    @Test
    public void testSettersAndGetters() {
        Factuur factuur = new Factuur(1, 1, new Date(), 450.0, true);

        factuur.setId(2);
        factuur.setBestellingId(2);
        Date newFactuurdatum = new Date();
        factuur.setFactuurdatum(newFactuurdatum);
        factuur.setBedrag(550.0);
        factuur.setBetaald(false);

        assertEquals(2, factuur.getId());
        assertEquals(2, factuur.getBestellingId());
        assertEquals(newFactuurdatum, factuur.getFactuurdatum());
        assertEquals(550.0, factuur.getBedrag());
        assertTrue(!factuur.isBetaald());
    }
}