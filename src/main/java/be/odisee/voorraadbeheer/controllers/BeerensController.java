package be.odisee.voorraadbeheer.controllers;

import be.odisee.voorraadbeheer.domain.Autosoort;
import be.odisee.voorraadbeheer.service.BeerensService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/beerens")
public class BeerensController {

    @Autowired
    private BeerensService beerensService;

    @GetMapping
    public ResponseEntity<List<Autosoort>> getAllAutosoorten() {
        List<Autosoort> autosoorten = (List<Autosoort>) beerensService.findAllAutosoorten();
        return new ResponseEntity<>(autosoorten, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autosoort> getAutosoortById(@PathVariable(value = "id") int id) {
        Autosoort autosoort = beerensService.findAutosoortById(id);
        return new ResponseEntity<>(autosoort, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Autosoort> createAutosoort(@Valid @RequestBody Autosoort autosoort) {
        Autosoort newAutosoort = beerensService.saveAutosoort(autosoort);
        return new ResponseEntity<>(newAutosoort, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autosoort> updateAutosoort(@PathVariable(value = "id") int id, @Valid @RequestBody Autosoort autosoortDetails) {
        Autosoort updatedAutosoort = beerensService.updateAutosoort(id, autosoortDetails);
        return new ResponseEntity<>(updatedAutosoort, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutosoort(@PathVariable(value = "id") int id) {
        beerensService.deleteAutosoort(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
