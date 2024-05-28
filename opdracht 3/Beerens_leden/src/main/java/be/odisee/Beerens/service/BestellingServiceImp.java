package be.odisee.Beerens.service;

import be.odisee.Beerens.domain.Bestelling;
import be.odisee.Beerens.dao.BestellingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BestellingServiceImp extends BestellingService {

    @Autowired
    private BestellingRepository bestellingRepository;

    @Override
    public List<Bestelling> findAll() {
        return bestellingRepository.findAll();
    }

    @Override
    public Bestelling findById(int id) {
        Optional<Bestelling> bestelling = bestellingRepository.findById(id);
        return bestelling.orElse(null);
    }

    @Override
    public Bestelling save(Bestelling bestelling) {
        return bestellingRepository.save(bestelling);
    }

    @Override
    public Bestelling update(int id, Bestelling bestellingDetails) {
        Optional<Bestelling> optionalBestelling = bestellingRepository.findById(id);
        if (optionalBestelling.isPresent()) {
            Bestelling existingBestelling = optionalBestelling.get();
            existingBestelling.setLidId(bestellingDetails.getLidId());
            existingBestelling.setAutosoortId(bestellingDetails.getAutosoortId());
            existingBestelling.setStartdatum(bestellingDetails.getStartdatum());
            existingBestelling.setEinddatum(bestellingDetails.getEinddatum());
            existingBestelling.setTotaalprijs(bestellingDetails.getTotaalprijs());
            // Update andere velden zoals nodig
            return bestellingRepository.save(existingBestelling);
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Optional<Bestelling> optionalBestelling = bestellingRepository.findById(id);
        if (optionalBestelling.isPresent()) {
            bestellingRepository.delete(optionalBestelling.get());
            return true;
        }
        return false;
    }
}
