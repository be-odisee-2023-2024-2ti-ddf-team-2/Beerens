package be.odisee.Beerens.dao;

import be.odisee.Beerens.domain.Bestelling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestellingRepository extends JpaRepository<Bestelling, Integer> {
}
