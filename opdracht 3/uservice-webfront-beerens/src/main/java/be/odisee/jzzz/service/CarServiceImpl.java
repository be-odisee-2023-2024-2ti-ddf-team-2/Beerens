package be.odisee.jzzz.service;

import be.odisee.jzzz.domain.Car;
import be.odisee.jzzz.helper.CarSummary;
import be.odisee.jzzz.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        Optional<Car> car = carRepository.findById(id);
        return car.orElse(null);
    }

    @Override
    public Car createCar(Car car) {
        car.setCreated(new Date());
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Long id, Car car) {
        if (!carRepository.existsById(id)) {
            return null;
        }
        car.setId(id);
        car.setUpdated(new Date());
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<CarSummary> getCarSummaries() {
        List<Car> cars = carRepository.findAll();
        List<CarSummary> summaries = new ArrayList<>();
        for (Car car : cars) {
            summaries.add(new CarSummary(car.getMerk(), car.getModel(), car.getBouwjaar(), car.getKenteken(), car.getDagtarief(), car.getCreated()));
        }
        return summaries;
    }
}
