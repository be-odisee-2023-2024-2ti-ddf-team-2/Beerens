package be.odisee.jzzz.service;

import be.odisee.jzzz.domain.Car;
import be.odisee.jzzz.helper.CarSummary;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();
    Car getCarById(Long id);
    Car createCar(Car car);
    Car updateCar(Long id, Car car);
    void deleteCar(Long id);
    List<CarSummary> getCarSummaries();
}
