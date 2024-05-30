package be.odisee.Beerens;

import be.odisee.Beerens.dao.BestellingRepository;
import be.odisee.Beerens.dao.FactuurRepository;
import be.odisee.Beerens.domain.Bestelling;
import be.odisee.Beerens.domain.Factuur;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class BeerensApplication {
    public static void main(String[] args) {
        SpringApplication.run(BeerensApplication.class, args);
    }
    @Bean
    CommandLineRunner init(BestellingRepository bestellingRepo, FactuurRepository factuurRepo) {
        return (args) -> {
            Calendar cal = Calendar.getInstance();
            Date today = cal.getTime();
            cal.add(Calendar.MONTH, -1);
            Date oneMonthAgo = cal.getTime();
            cal.add(Calendar.YEAR, +1);
            Date elevenMonthsFromNow = cal.getTime();
            cal.add(Calendar.MONTH, -1);
            Date tenMonthsFromNow = cal.getTime();

            bestellingRepo.save(new Bestelling(1, 1, 1, today, elevenMonthsFromNow, 450.0));
            bestellingRepo.save(new Bestelling(2, 2, 2, oneMonthAgo, tenMonthsFromNow, 300.0));
            bestellingRepo.save(new Bestelling(3, 3, 3, today, oneMonthAgo, 250.0));

            factuurRepo.save(new Factuur("2024-05-30", 100));
            factuurRepo.save(new Factuur("2024-05-31", 200));
            factuurRepo.save(new Factuur("2024-06-01", 300));
        };
    }
}