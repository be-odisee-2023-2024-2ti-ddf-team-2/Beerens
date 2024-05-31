package be.odisee.jzzz.helper;

import be.odisee.jzzz.domain.Autosoort;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Geen echte domeinklasse, maar meer een - nadelig - gevolg van microservices
 * We willen een lijst van aanwezigen
 * De namen zullen komen van de leden microservice
 * De andere informatie zal komen uit de toegang microservice
 * 
 * @author hans
 *
 */
public class AutosoortHelper {

	// Een voorbeeldmethode om Autosoor objecten te filteren op een bepaald criterium
	public List<Autosoort> filterByType(List<Autosoort> autosoorten, String type) {
		return autosoorten.stream()
				.filter(autosoort -> autosoort.getType().equalsIgnoreCase(type))
				.collect(Collectors.toList());
	}

	// Een voorbeeldmethode om een string te genereren voor weergave
	public String generateDisplayName(Autosoort autosoort) {
		return autosoort.getMerk() + " " + autosoort.getModel();
	}

	// Een voorbeeldmethode om de totale waarde van een lijst van Autosoor objecten te berekenen
	public double calculateTotalValue(List<Autosoort> autosoorten) {
		return autosoorten.stream()
				.mapToDouble(Autosoort::getPrijs)
				.sum();
	}
}
