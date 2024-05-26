package be.odisee.jzzz.repository;

import be.odisee.jzzz.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
