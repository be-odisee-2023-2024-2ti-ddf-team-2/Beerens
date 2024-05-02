package be.odisee.voorraadbeheer.service;

import be.odisee.voorraadbeheer.dao.AutosoortRepository;
import be.odisee.voorraadbeheer.domain.Entry;
import be.odisee.voorraadbeheer.domain.Project;
import be.odisee.voorraadbeheer.formdata.EntryData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface BeerensService {

    @Autowired
    private AutosoortRepository autosoortRepository;

    public List<Autosoort> findAllAutosoorten() {
        return autosoortRepository.findAll();
    }

    public Autosoort findAutosoortById(int id) {
        return autosoortRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Autosoort not found"));
    }

    public Autosoort saveAutosoort(Autosoort autosoort) {
        return autosoortRepository.save(autosoort);
    }

    public Autosoort updateAutosoort(int id, Autosoort autosoortDetails) {
        Autosoort autosoort = findAutosoortById(id);
        // Update de velden van autosoort met autosoortDetails
        return autosoortRepository.save(autosoort);
    }

    public void deleteAutosoort(int id) {
        Autosoort autosoort = findAutosoortById(id);
        autosoortRepository.delete(autosoort);
    }
}
