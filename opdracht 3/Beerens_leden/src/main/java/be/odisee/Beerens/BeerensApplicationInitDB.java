package be.odisee.Beerens;

import be.odisee.Beerens.dao.BestellingRepository;
    import be.odisee.Beerens.domain.Bestelling;
import be.odisee.Beerens.dao.FactuurRepository;
import be.odisee.Beerens.domain.Factuur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class BeerensApplicationInitDB implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

    }
}
