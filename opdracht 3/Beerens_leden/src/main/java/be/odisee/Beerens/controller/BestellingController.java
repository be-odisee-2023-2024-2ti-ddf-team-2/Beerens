package be.odisee.Beerens.controller;

import be.odisee.Beerens.domain.Bestelling;
import be.odisee.Beerens.service.BestellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bestellingen")
public class BestellingController {

    @Autowired
    private BestellingService bestellingService;

    @GetMapping
    public List<Bestelling> getAllBestellingen() {
        return bestellingService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bestelling> getBestellingById(@PathVariable int id) {
        Bestelling bestelling = bestellingService.findById(id);
        if (bestelling != null) {
            return ResponseEntity.ok(bestelling);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Bestelling createBestelling(@RequestBody Bestelling bestelling) {
        return bestellingService.save(bestelling);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bestelling> updateBestelling(@PathVariable int id, @RequestBody Bestelling bestellingDetails) {
        Bestelling updatedBestelling = bestellingService.update(id, bestellingDetails);
        if (updatedBestelling != null) {
            return ResponseEntity.ok(updatedBestelling);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBestelling(@PathVariable int id) {
        if (bestellingService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}