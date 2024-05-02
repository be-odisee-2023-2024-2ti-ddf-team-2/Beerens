package be.odisee.voorraadbeheer;

import be.odisee.voorraadbeheer.dao.AutosoortRepository;
import be.odisee.voorraadbeheer.domain.Autosoort;
import be.odisee.voorraadbeheer.domain.ToyotaCamry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
@Slf4j
public class BeerensApplicationInitDB implements CommandLineRunner {

    @Autowired
    private AutosoortRepository autosoortRepository;

    @Override
    public void run(String... args) throws Exception {
        // Define initial data including ToyotaCamry
        List<Autosoort> autosoorts = Arrays.asList(
                new ToyotaCamry("Camry", "Toyota", 200, 20, 70)
        );

        // Save initial data
        log.info("Saving initial data...");
        autosoortRepository.saveAll(autosoorts);
        log.info("Initial data saved successfully.");
    }
}
