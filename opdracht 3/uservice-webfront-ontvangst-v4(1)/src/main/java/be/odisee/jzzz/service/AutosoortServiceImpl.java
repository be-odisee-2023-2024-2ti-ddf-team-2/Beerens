package be.odisee.jzzz.service;

import be.odisee.jzzz.domain.Autosoort;
import be.odisee.jzzz.helper.AutosoortHelper;
import be.odisee.jzzz.repository.AutosoortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutosoortServiceImpl implements AutosoortService {

    @Autowired
    private AutosoortRepository autosoortRepository;
    private final AutosoortHelper autosoortHelper = new AutosoortHelper();


    @Override
    public List<Autosoort> findAll() {
        return (List<Autosoort>) autosoortRepository.findAll();
    }

    @Override
    public Optional<Autosoort> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Autosoort save(Autosoort autosoort) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Autosoort> findByMerkAndModel(String merk, String model) {
        return null;
    }
    public List<Autosoort> findByType(String type) {
        List<Autosoort> allAutosoorten = findAll();
        return autosoortHelper.filterByType(allAutosoorten, type);
    }

    public double getTotalValue() {
        List<Autosoort> allAutosoorten = findAll();
        return autosoortHelper.calculateTotalValue(allAutosoorten);
    }
}