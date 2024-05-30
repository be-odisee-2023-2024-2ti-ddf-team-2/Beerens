package be.odisee.jzzz;

import java.util.Calendar;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import be.odisee.jzzz.dao.AutosoortRepository;
import be.odisee.jzzz.domain.Autosoort;

@SpringBootApplication
public class BeerensAutosoortApplication {
    public static void main(String[] args) {
        SpringApplication.run(BeerensAutosoortApplication.class, args);
    }

    @Bean
    CommandLineRunner init(AutosoortRepository repo) {
        return (evt) -> {
            Calendar cal = Calendar.getInstance();
            Date today = cal.getTime();
            cal.add(Calendar.MONTH, -1);
            Date oneMonthAgo = cal.getTime();
            cal.add(Calendar.YEAR, +1);
            Date elevenMonthsFromNow = cal.getTime();
            cal.add(Calendar.MONTH, -1);
            Date tenMonthsFromNow = cal.getTime();

            repo.save(new Autosoort("Toyota", "Corolla", 2020));
            repo.save(new Autosoort("Honda", "Civic", 2019));
            repo.save(new Autosoort("Ford", "Focus", 2018));
            repo.save(new Autosoort("Chevrolet", "Malibu", 2021));
            repo.save(new Autosoort("Nissan", "Sentra", 2022));
            repo.save(new Autosoort("BMW", "3 Series", 2020));
            repo.save(new Autosoort("Audi", "A4", 2017));
        };
    }
}

