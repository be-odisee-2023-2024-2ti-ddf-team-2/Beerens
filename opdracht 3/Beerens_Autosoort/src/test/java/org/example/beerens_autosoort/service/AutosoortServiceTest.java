package org.example.beerens_autosoort.service;

import org.example.beerens_autosoort.dao.AutosoortRepository;
import org.example.beerens_autosoort.domain.Autosoort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AutosoortServiceTest {

    @Mock
    private AutosoortRepository autosoortRepository;

    @InjectMocks
    private AutosoortService autosoortService;

    private Autosoort autosoort1;
    private Autosoort autosoort2;

    @BeforeEach
    public void setUp() {
        autosoort1 = new Autosoort(1, " Toyota", "Yaris", 2020, "AB-123-CD", 45.00);
        autosoort2 = new Autosoort(2, "Volkswagen", "Golf", 2019, "EF-456-GH", 50.00);
    }

    @Test
    public void testFindAll() {
        when(autosoortRepository.findAll()).thenReturn(Arrays.asList(autosoort1, autosoort2));

        List<Autosoort> autosoorten = autosoortService.findAll();

        assertEquals(2, autosoorten.size());
        verify(autosoortRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        when(autosoortRepository.findById(1)).thenReturn(Optional.of(autosoort1));

        Autosoort found = autosoortService.findById(1);

        assertNotNull(found);
        assertEquals(" Toyota", found.getMerk());
        verify(autosoortRepository, times(1)).findById(1);
    }

    @Test
    public void testSave() {
        when(autosoortRepository.save(autosoort1)).thenReturn(autosoort1);

        Autosoort saved = autosoortService.save(autosoort1);

        assertNotNull(saved);
        assertEquals(" Toyota", saved.getMerk());
        verify(autosoortRepository, times(1)).save(autosoort1);
    }

    @Test
    public void testUpdate() {
        Autosoort updatedDetails = new Autosoort(1, "Toyota", "Yaris", 2021, "AB-123-CD", 50.00);
        when(autosoortRepository.findById(1)).thenReturn(Optional.of(autosoort1));
        when(autosoortRepository.save(autosoort1)).thenReturn(autosoort1);

        Autosoort updated = autosoortService.update(1, updatedDetails);

        assertNotNull(updated);
        assertEquals(2021, updated.getBouwjaar());
        assertEquals(50.00, updated.getDagtarief());
        verify(autosoortRepository, times(1)).findById(1);
        verify(autosoortRepository, times(1)).save(autosoort1);
    }

    @Test
    public void testDelete() {
        when(autosoortRepository.existsById(1)).thenReturn(true);

        boolean isDeleted = autosoortService.delete(1);

        assertTrue(isDeleted);
        verify(autosoortRepository, times(1)).deleteById(1);
    }

    @Test
    public void testDeleteNotFound() {
        when(autosoortRepository.existsById(1)).thenReturn(false);

        boolean isDeleted = autosoortService.delete(1);

        assertFalse(isDeleted);
        verify(autosoortRepository, never()).deleteById(1);
    }
}
