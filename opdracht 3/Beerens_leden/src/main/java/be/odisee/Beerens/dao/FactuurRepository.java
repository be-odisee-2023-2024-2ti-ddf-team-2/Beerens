package be.odisee.Beerens.dao;

import be.odisee.Beerens.domain.Factuur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactuurRepository extends JpaRepository<Factuur, Integer> {
}