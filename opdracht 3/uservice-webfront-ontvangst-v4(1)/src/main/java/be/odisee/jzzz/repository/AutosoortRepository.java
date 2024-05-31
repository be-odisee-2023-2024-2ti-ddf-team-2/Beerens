package be.odisee.jzzz.repository;

import be.odisee.jzzz.domain.Autosoort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AutosoortRepository extends CrudRepository<Autosoort, Integer> {
    List<Autosoort> findByMerkAndModel(String merk, String model);
}
