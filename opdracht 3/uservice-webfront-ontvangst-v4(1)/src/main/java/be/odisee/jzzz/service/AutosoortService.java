package be.odisee.jzzz.service;

import java.util.List;
import java.util.Optional;

import be.odisee.jzzz.domain.Autosoort;

public interface AutosoortService {
	List<Autosoort> findAll();
	Optional<Autosoort> findById(int id);
	Autosoort save(Autosoort autosoort);
	void deleteById(int id);
	List<Autosoort> findByMerkAndModel(String merk, String model);
}