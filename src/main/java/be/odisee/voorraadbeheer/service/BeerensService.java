package be.odisee.voorraadbeheer.service;

import be.odisee.voorraadbeheer.domain.Entry;
import be.odisee.voorraadbeheer.domain.Project;
import be.odisee.voorraadbeheer.formdata.EntryData;
import jakarta.validation.Valid;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface BeerensService {

    public Map<String, List<Project> > getCategoriesWithProjects();

    public Object getObjectives();

    public EntryData prepareNewEntryData();

    public String processEntry(@Valid EntryData entryData);

    public List<Entry> getEntriesFromDate(LocalDate theDate);

    public Duration getTotalDuration(List<Entry> entries);

    public EntryData prepareEntryDataToEdit(long id);

    public void deleteEntry(long id);
}
