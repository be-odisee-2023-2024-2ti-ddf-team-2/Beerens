package be.odisee.jzzz.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import be.odisee.jzzz.dao.AutosoortRepository;
import be.odisee.jzzz.domain.Autosoort;

@Service
public class AutosoortService {

	@Autowired
	private AutosoortRepository autosoortRepository;

	public List<Autosoort> findAll() {
		return (List<Autosoort>) autosoortRepository.findAll();
	}

	public Autosoort findById(int id) {
		return autosoortRepository.findById(id).orElse(null);
	}

	public Autosoort save(Autosoort autosoort) {
		return autosoortRepository.save(autosoort);
	}

	public Autosoort update(int id, Autosoort autosoortDetails) {
		return autosoortRepository.findById(id)
				.map(autosoort -> {
					autosoort.setMerk(autosoortDetails.getMerk());
					autosoort.setModel(autosoortDetails.getModel());
					autosoort.setBouwjaar(autosoortDetails.getBouwjaar());
					autosoort.setKenteken(autosoortDetails.getKenteken());
					autosoort.setDagtarief(autosoortDetails.getDagtarief());
					return autosoortRepository.save(autosoort);
				})
				.orElse(null);
	}

	public boolean delete(int id) {
		if (autosoortRepository.existsById(id)) {
			autosoortRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}