package be.odisee.voorraadbeheer.service;

import be.odisee.voorraadbeheer.domain.Autosoort;
import be.odisee.voorraadbeheer.formdata.EntryData;

import java.util.List;
import java.util.Map;

public interface BeerensService {

    Iterable<Autosoort> findAllAutosoorten();

    Autosoort findAutosoortById(int id);

    Autosoort saveAutosoort(Autosoort autosoort);

    Autosoort updateAutosoort(int id, Autosoort autosoortDetails);

    void deleteAutosoort(int id);

    Map<String, List<Autosoort>> getCategoriesWithAutosoorten();

    String processEntry(EntryData entryData);

    List<Autosoort> getAutosoorten();

    Autosoort getAutosoortById(int id);
}
