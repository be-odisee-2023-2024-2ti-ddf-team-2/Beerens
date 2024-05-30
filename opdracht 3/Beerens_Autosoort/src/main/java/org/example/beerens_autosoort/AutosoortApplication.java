package org.example.beerens_autosoort;

import org.example.beerens_autosoort.dao.AutosoortRepository;
import org.example.beerens_autosoort.domain.Autosoort;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class AutosoortApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutosoortApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(AutosoortRepository autosoortRepo) {
        return (args) -> {
            // Get current date
            Calendar cal = Calendar.getInstance();
            Date today = cal.getTime();

            // Create and save Autosoort entities
            autosoortRepo.save(new Autosoort("Toyota", "Corolla", 2022, "ABC123", 50.0));
            autosoortRepo.save(new Autosoort("Honda", "Civic", 2021, "XYZ789", 60.0));
            autosoortRepo.save(new Autosoort("Ford", "Focus", 2023, "DEF456", 55.0));
        };
    }
}