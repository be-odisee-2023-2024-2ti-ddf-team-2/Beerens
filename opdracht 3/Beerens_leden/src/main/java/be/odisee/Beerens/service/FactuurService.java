package be.odisee.Beerens.service;

import be.odisee.Beerens.domain.Factuur;
import be.odisee.Beerens.dao.FactuurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactuurService {

    @Autowired
    private FactuurRepository factuurRepository;

    public List<Factuur> findAll() {
        return factuurRepository.findAll();
    }

    public Factuur findById(int id) {
        return factuurRepository.findById(id).orElse(null);
    }

    public Factuur save(Factuur factuur) {
        return factuurRepository.save(factuur);
    }

    public Factuur update(int id, Factuur factuurDetails) {
        return factuurRepository.findById(id)
                .map(factuur -> {
                    factuur.setBestellingId(factuurDetails.getBestellingId());
                    factuur.setFactuurdatum(factuurDetails.getFactuurdatum());
                    factuur.setBedrag(factuurDetails.getBedrag());
                    factuur.setBetaald(factuurDetails.isBetaald());
                    return factuurRepository.save(factuur);
                })
                .orElse(null);
    }

    public boolean delete(int id) {
        if (factuurRepository.existsById(id)) {
            factuurRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
