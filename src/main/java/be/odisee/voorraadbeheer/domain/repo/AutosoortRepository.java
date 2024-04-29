package be.odisee.voorraadbeheer.domain.repo;

import be.odisee.voorraadbeheer.domain.domain.Autosoort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutosoortRepository extends JpaRepository<Autosoort, Integer> {
    // Standaard CRUD-operaties zijn hier beschikbaar
}
