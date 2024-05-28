package org.example.beerens_autosoort.controller;

import org.example.beerens_autosoort.domain.Autosoort;
import org.example.beerens_autosoort.service.AutosoortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autosoorten")
public class AutosoortController {

    @Autowired
    private AutosoortService autosoortService;

    @GetMapping
    public List<Autosoort> getAllAutosoorten() {
        return autosoortService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autosoort> getAutosoortById(@PathVariable int id) {
        Autosoort autosoort = autosoortService.findById(id);
        if (autosoort != null) {
            return ResponseEntity.ok(autosoort);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Autosoort createAutosoort(@RequestBody Autosoort autosoort) {
        return autosoortService.save(autosoort);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autosoort> updateAutosoort(@PathVariable int id, @RequestBody Autosoort autosoortDetails) {
        Autosoort updatedAutosoort = autosoortService.update(id, autosoortDetails);
        if (updatedAutosoort != null) {
            return ResponseEntity.ok(updatedAutosoort);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutosoort(@PathVariable int id) {
        if (autosoortService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
