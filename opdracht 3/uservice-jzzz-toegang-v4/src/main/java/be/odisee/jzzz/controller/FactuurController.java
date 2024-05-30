package be.odisee.jzzz.controller;

import be.odisee.jzzz.domain.Factuur;
import be.odisee.jzzz.service.FactuurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturen")
public class FactuurController {
    @Autowired
    private FactuurService factuurService;

    @GetMapping
    public List<Factuur> getAllFacturen(){
        return factuurService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factuur> getFactuurById(@PathVariable int id){
        Factuur factuur = factuurService.findById(id);
        if (factuur != null){
            return ResponseEntity.ok(factuur);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Factuur createFactuur(@RequestBody Factuur factuur){
        return factuurService.save(factuur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factuur> updateFactuur(@PathVariable int id, @RequestBody Factuur factuurDetails){
        Factuur updatedFactuur = factuurService.update(id, factuurDetails);
        if(updatedFactuur != null){
            return ResponseEntity.ok(updatedFactuur);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFactuur(@PathVariable int id){
        if (factuurService.delete(id)){
            return ResponseEntity.noContent().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}
