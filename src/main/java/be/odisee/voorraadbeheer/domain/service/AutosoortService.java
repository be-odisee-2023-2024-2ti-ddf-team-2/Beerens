package be.odisee.voorraadbeheer.domain.service;

import be.odisee.voorraadbeheer.domain.domain.Autosoort;
import be.odisee.voorraadbeheer.domain.repo.AutosoortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutosoortService {
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
