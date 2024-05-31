package be.odisee.jzzz;

import be.odisee.jzzz.dao.FactuurRepository;
import be.odisee.jzzz.domain.Factuur;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class BeerensFactuurApplication {
    public static void main(String[] args) {
        SpringApplication.run(BeerensFactuurApplication.class, args);
    }

    @Bean
    CommandLineRunner init(FactuurRepository repo) {
        return (args) -> {
            Calendar cal = Calendar.getInstance();
            Date today = cal.getTime();

            repo.save(new Factuur(today, 450.0));
        };
    }
}
