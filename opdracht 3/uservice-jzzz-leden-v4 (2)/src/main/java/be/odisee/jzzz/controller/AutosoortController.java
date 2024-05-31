package be.odisee.jzzz.controller;

import be.odisee.jzzz.service.AutosoortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import be.odisee.jzzz.domain.Autosoort;

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
