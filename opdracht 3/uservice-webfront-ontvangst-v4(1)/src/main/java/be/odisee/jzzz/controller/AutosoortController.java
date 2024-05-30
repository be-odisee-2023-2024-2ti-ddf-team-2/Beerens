package be.odisee.jzzz.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.odisee.jzzz.domain.*;

import be.odisee.jzzz.service.AutosoortService;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
@RestController
public class AutosoortController {

	@Autowired
	private AutosoortService autosoortService;

	/**
	 * Helpermethode: datum van vandaag op model zetten
	 *
	 * @param model
	 */
	private void zetDatum(ModelMap model) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String vandaag = dateFormat.format(new java.util.Date());
		model.addAttribute("today", vandaag);
	}

	/**
	 * Informatie bijeenbrengen om het zoekscherm te tonen
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/", "/home.html", "/index.html", "/zoekautosoorten.html"}, method=RequestMethod.GET)
	public String index(ModelMap model) {

		// Datum van vandaag op het model zetten
		zetDatum(model);

		// Formulier om opzoekpatronen in te geven voorbereiden met leeg Autosoort-object
		Autosoort autosoort = new Autosoort();
		model.addAttribute("zoekautosoort", autosoort);

		return "index";
	}

	/**
	 * Een lijst van autosoorten opzoeken die voldoen aan merk + model criteria
	 *
	 * @param zoekautosoort
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/", "/home.html", "/index.html", "/zoekautosoorten.html"}, method=RequestMethod.POST, params={"zoek"})
	public String zoekAutosoorten(@ModelAttribute("zoekautosoort") Autosoort zoekautosoort, ModelMap model) {

		// Datum van vandaag op het model zetten
		zetDatum(model);

		// Zoeken van autosoorten op combinatie van merk + model
		List<Autosoort> autosoorten = autosoortService.findByMerkAndModel(zoekautosoort.getMerk(), zoekautosoort.getModel());

		// Model opvullen
		model.addAttribute("zoekautosoort", zoekautosoort);
		model.addAttribute("autosoorten", autosoorten);

		return "index";
	}

	/**
	 * Een formulier tonen om een nieuwe autosoort in te voeren, want er werd op de "Nieuw" knop gedrukt
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/", "/home.html", "/index.html", "/zoekautosoorten.html"}, method=RequestMethod.POST, params={"nieuw"})
	public String nieuwAutosoortFormulier(@ModelAttribute("zoekautosoort") Autosoort autosoort, ModelMap model) {

		// Model opvullen
		model.addAttribute("nieuwautosoort", autosoort);

		return "nieuwautosoort";
	}

	/**
	 * Er werden gegevens voor een nieuwe autosoort ingevoerd en op de knop Toevoegen geklikt
	 *
	 * @param autosoort een object met de gegevens van de nieuwe autosoort
	 * @param model
	 * @return de naam van de view die de gebruiker zal informeren van de goede afloop
	 */
	@RequestMapping(value={"/nieuwautosoort.html"}, method=RequestMethod.POST)
	public String nieuwAutosoortToevoegen(@ModelAttribute("nieuwautosoort") Autosoort autosoort, ModelMap model) {

		// Datum van vandaag op het model zetten
		zetDatum(model);

		// Formulier om opzoekpatronen in te geven voorbereiden met leeg Autosoort-object
		Autosoort zoekautosoort = new Autosoort();
		model.addAttribute("zoekautosoort", zoekautosoort);

		// Nieuwe autosoort toevoegen
		autosoortService.save(autosoort);
		model.addAttribute("boodschap", "Nieuwe autosoort toegevoegd: " + autosoort.getMerk() + " " + autosoort.getModel());

		return "boodschap";
	}

	/**
	 * Toont een lijst van alle autosoorten
	 *
	 * @param model
	 * @return de naam van de view die de lijst zal tonen
	 */
	@RequestMapping(value={"/alleautosoorten.html"}, method=RequestMethod.GET)
	public String alleAutosoorten(ModelMap model) {

		// Datum van vandaag op het model zetten
		zetDatum(model);

		// Zoeken van alle autosoorten
		List<Autosoort> autosoorten = autosoortService.findAll();

		// Model opvullen
		model.addAttribute("autosoorten", autosoorten);

		return "alleautosoorten";
	}
}
