package be.odisee.jzzz.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import be.odisee.jzzz.domain.Autosoort;

@RepositoryRestResource
public interface AutosoortRepository extends CrudRepository<Autosoort, Integer> {
	// Zoek naar autosoorten op basis van merk
	List<Autosoort> findByMerk(String merk);

	// Zoek naar autosoorten op basis van model
	List<Autosoort> findByModel(String model);

	// Zoek naar autosoorten op basis van bouwjaar
	List<Autosoort> findByBouwjaar(int bouwjaar);

	// Zoek naar autosoorten op basis van kenteken
	List<Autosoort> findByKenteken(String kenteken);

	// Zoek naar autosoorten op basis van dagtarief
	List<Autosoort> findByDagtarief(double dagtarief);
}