package be.odisee.voorraadbeheer.domain.controllers;

import be.odisee.voorraadbeheer.domain.domain.Autosoort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


import java.util.List;

@RestController
@RequestMapping("/autosoorten")
public class AutosoortController {
    @Autowired
    private AutosoortService autosoortService;

    // HTTP Endpoints voor CRUD operaties
    @GetMapping
    public ResponseEntity<List<Autosoort>> getAllAutosoorten() {
        List<Autosoort> autosoorten = autosoortService.findAllAutosoorten();
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
