package be.odisee.jzzz.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import be.odisee.jzzz.domain.Factuur;

public interface FactuurRepository extends CrudRepository<Factuur, Integer> {
	List<Factuur> findByFactuurdatumBetween(Date startDate, Date endDate);
}