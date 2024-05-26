package be.odisee.jzzz.controller;

import be.odisee.jzzz.domain.Car;
import be.odisee.jzzz.service.CarService;
import be.odisee.jzzz.helper.CarFilter;
import be.odisee.jzzz.helper.CarSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public String getAllCars(ModelMap model) {
        List<CarSummary> cars = carService.getCarSummaries();
        model.addAttribute("cars", cars);
        model.addAttribute("carFilter", new CarFilter());
        return "index";
    }

    @PostMapping("/search")
    public String searchCars(@ModelAttribute CarFilter carFilter, ModelMap model) {
        // Implement search functionality using carFilter
        List<CarSummary> cars = carService.getCarSummaries(); // Replace with actual search logic
        model.addAttribute("cars", cars);
        model.addAttribute("carFilter", carFilter);
        return "index";
    }

    @GetMapping("/create")
    public String createCarForm(ModelMap model) {
        model.addAttribute("car", new Car());
        return "createCar";
    }


    @PostMapping
    public String createCar(@ModelAttribute Car car) {
        carService.createCar(car);
        return "redirect:/cars";
    }

    @GetMapping("/edit/{id}")
    public String editCarForm(@PathVariable Long id, ModelMap model) {
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        return "updateCar";
    }

    @PostMapping("/update/{id}")
    public String updateCar(@PathVariable Long id, @ModelAttribute Car car) {
        carService.updateCar(id, car);
        return "redirect:/cars";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return "redirect:/cars";
    }
}
