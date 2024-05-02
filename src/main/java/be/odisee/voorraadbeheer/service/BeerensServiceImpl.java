package be.odisee.voorraadbeheer.service;

import be.odisee.voorraadbeheer.dao.AutosoortRepository;
import be.odisee.voorraadbeheer.domain.Autosoort;
import be.odisee.voorraadbeheer.formdata.EntryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BeerensServiceImpl implements BeerensService {

    @Autowired
    private AutosoortRepository autosoortRepository;

    @Override
    public List<Autosoort> findAllAutosoorten() {
        return (List<Autosoort>) autosoortRepository.findAll();
    }

    @Override
    public Optional<Autosoort> findAutosoortById(int id) {
        return autosoortRepository.findById(id);
    }

    @Override
    public Autosoort saveAutosoort(Autosoort autosoort) {
        return autosoortRepository.save(autosoort);
    }

    @Override
    public Autosoort updateAutosoort(int id, Autosoort autosoortDetails) {
        Optional<Autosoort> optionalAutosoort = autosoortRepository.findById(id);
        if (optionalAutosoort.isPresent()) {
            Autosoort existingAutosoort = optionalAutosoort.get();
            existingAutosoort.setStatus(autosoortDetails.getStatus());
            existingAutosoort.setNaam(autosoortDetails.getNaam());
            existingAutosoort.setMerk(autosoortDetails.getMerk());
            return autosoortRepository.save(existingAutosoort);
        } else {
            return null;
        }
    }

    @Override
    public void deleteAutosoort(int id) {
        autosoortRepository.deleteById(id);
    }

    @Override
    public Map<String, List<Autosoort>> getCategoriesWithAutosoorten() {
        return null;
    }

    @Override
    public String processEntry(EntryData entryData) {
        return null;
    }

    @Override
    public List<Autosoort> getAutosoorten() {
        return null;
    }

    @Override
    public Autosoort getAutosoortById(int id) {
        return null;
    }
}
