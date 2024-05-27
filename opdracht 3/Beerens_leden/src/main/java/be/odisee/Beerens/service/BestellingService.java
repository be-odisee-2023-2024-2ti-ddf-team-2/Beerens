package be.odisee.Beerens.service;

import be.odisee.Beerens.domain.Bestelling;
import be.odisee.Beerens.dao.BestellingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BestellingService {

    @Autowired
    private BestellingRepository bestellingRepository;

    public List<Bestelling> findAll() {
        return bestellingRepository.findAll();
    }

    public Bestelling findById(int id) {
        return bestellingRepository.findById(id).orElse(null);
    }

    public Bestelling save(Bestelling bestelling) {
        return bestellingRepository.save(bestelling);
    }

    public Bestelling update(int id, Bestelling bestellingDetails) {
        Bestelling bestelling = bestellingRepository.findById(id).orElse(null);
        if (bestelling != null) {
            bestelling.setLidId(bestellingDetails.getLidId());
            bestelling.setAutosoortId(bestellingDetails.getAutosoortId());
            bestelling.setStartdatum(bestellingDetails.getStartdatum());
            bestelling.setEinddatum(bestellingDetails.getEinddatum());
            bestelling.setTotaalprijs(bestellingDetails.getTotaalprijs());
            return bestellingRepository.save(bestelling);
        } else {
            return null;
        }
    }

    public boolean delete(int id) {
        if (bestellingRepository.existsById(id)) {
            bestellingRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
