package org.example.beerens_autosoort.dao;


import org.example.beerens_autosoort.domain.Autosoort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutosoortRepository extends JpaRepository<Autosoort, Integer> {
}
