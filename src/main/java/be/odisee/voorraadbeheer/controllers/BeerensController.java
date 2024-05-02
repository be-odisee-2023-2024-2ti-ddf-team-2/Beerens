package be.odisee.voorraadbeheer.controllers;

import be.odisee.voorraadbeheer.domain.Autosoort;

import be.odisee.voorraadbeheer.service.BeerensService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.validation.Errors;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/beerens")
public class BeerensController {

    @Autowired
    private BeerensService beerensService;

    // HTTP Endpoints voor CRUD operaties
    @GetMapping
    public ResponseEntity<List<Autosoort>> getAllAutosoorten() {
        List<Autosoort> autosoorten = beerensService.findAllAutosoorten();
        return new ResponseEntity<>(autosoorten, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autosoort> getAutosoortById(@PathVariable(value = "id") int id) {
        Autosoort autosoort = autosoortService.findAutosoortById(id);
        return new ResponseEntity<>(autosoort, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Autosoort> createAutosoort(@RequestBody Autosoort autosoort) {
        Autosoort newAutosoort = autosoortService.saveAutosoort(autosoort);
        return new ResponseEntity<>(newAutosoort, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autosoort> updateAutosoort(@PathVariable(value = "id") int id, @RequestBody Autosoort autosoortDetails) {
        Autosoort updatedAutosoort = autosoortService.updateAutosoort(id, autosoortDetails);
        return new ResponseEntity<>(updatedAutosoort, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAutosoort(@PathVariable(value = "id") int id) {
        autosoortService.deleteAutosoort(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
