package be.odisee.voorraadbeheer.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootApplication
public class BeerensClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeerensClientApplication.class, args);

        String baseUrl = "http://localhost:8080/api/autosoorten";

        WebClient webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();

        System.out.println("________________________");

        // REST GET requests a resource (one)

        AutosoortDTO autosoort = webClient
                .get()
                .uri("/5")
                .retrieve()
                .bodyToMono(AutosoortDTO.class)
                .block();

        System.out.println("Via REST retrieved the following autosoort: "
                + autosoort.getNaam() + " " + autosoort.getMerk());

        // REST GET requests a resource (list)

        List<AutosoortDTO> autosoorten = webClient
                .get()
                .uri("")
                .retrieve()
                .bodyToFlux(AutosoortDTO.class)
                .collectList()
                .block();

        System.out.println("\nretrieved the autosoorten: ");
        for (AutosoortDTO a : autosoorten) {
            System.out.println(a.getNaam() + " " + a.getMerk());
        }

        // REST PUT updates a resource

        autosoort.setNaam("Update Model");

        autosoort = webClient
                .put()
                .uri("/5")
                .body(Mono.just(autosoort), AutosoortDTO.class)
                .retrieve()
                .bodyToMono(AutosoortDTO.class)
                .block();

        System.out.println("\nVia REST updated autosoort to: "
                + autosoort.getNaam() + " " + autosoort.getMerk());

        // REST PUT updates a non-existing resource

        try {
            autosoort = webClient
                    .put()
                    .uri("/999")
                    .body(Mono.just(autosoort), AutosoortDTO.class)
                    .retrieve()
                    .onStatus(HttpStatusCode::isError,
                            response -> {
                                if (response.statusCode().value() == 404)
                                    return Mono.error(new Exception("404 - Not Found"));
                                else
                                    return Mono.error(new Exception("Something else than 404 went wrong"));
                            })
                    .bodyToMono(AutosoortDTO.class)
                    .block();
        } catch (Exception e) {
            System.out.println("\nSomething went wrong: " + e.getMessage());
        }

        // REST POST creates a new resource

        autosoort = new AutosoortDTO();
        autosoort.setNaam("New Model");
        autosoort.setMerk("New Brand");
        autosoort.setHuidigVoorraadniveau(100);
        autosoort.setMinimumpeiler(20);
        autosoort.setMaximumpeiler(200);
        autosoort.setStatus("Available");

        autosoort = webClient
                .post()
                .uri("")
                .body(Mono.just(autosoort), AutosoortDTO.class)
                .retrieve()
                .bodyToMono(AutosoortDTO.class)
                .block();

        long autosoortId = autosoort.getId();

        System.out.println("\nVia REST added a new autosoort: "
                + autosoort.getNaam() + " " + autosoort.getMerk() + " with id " + autosoortId);

        // REST DELETE deletes a resource

        webClient
                .delete()
                .uri("/" + autosoortId)
                .retrieve()
                .bodyToMono(Void.class)
                .block();

        System.out.println("\nVia REST deleted the newly created resource");

        System.out.println("________________________");
    }
}
