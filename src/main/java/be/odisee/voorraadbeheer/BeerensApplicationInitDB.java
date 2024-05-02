package be.odisee.voorraadbeheer;

import be.odisee.voorraadbeheer.dao.AnalyseMarktvraagRepository;
import be.odisee.voorraadbeheer.dao.AutosoortRepository;
import be.odisee.voorraadbeheer.dao.BeerensMedewerkerRepository;
import be.odisee.voorraadbeheer.domain.BestellingRepository;
import be.odisee.voorraadbeheer.domain.FactuurRepository;
import be.odisee.voorraadbeheer.domain.TipRepository;
import be.odisee.voorraadbeheer.domain.VerkoopRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Database initializer that populates the database with some
 * initial data.
 *
 * This component is started only when app.db-init property is set to true
 */
@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class BeerensApplicationInitDB implements CommandLineRunner {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ObjectiveRepository objectiveRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Category> categories = Arrays.asList(
                new Category(1, "OVHD"),
                new Category(2, "NETW")
        );

        for (Category category : categories) {
            categoryRepository.save(category);
        };

        List<Project> projects = Arrays.asList(
                new Project(1, "General", categoryRepository.findCategoryByName("OVHD")),
                new Project(2, "Infrastructure", categoryRepository.findCategoryByName("OVHD") )
        );

        for (Project project: projects) {
            projectRepository.save(project);
        }

        List<Objective> objectives = Arrays.asList(
                new Objective(1, "Omzet zelfstandig"),
                new Objective(2, "Omzet digitaal")
        );

        for (Objective objective: objectives) {
            objectiveRepository.save(objective);
        }
    }
}
