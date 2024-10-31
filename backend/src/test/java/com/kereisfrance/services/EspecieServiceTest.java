package com.kereisfrance.services;

import com.kereisfrance.dto.EspecieDTO;
import com.kereisfrance.dto.EspecieListDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EspecieServiceTest {

    @Mock
    private RestTemplate restTemplate;
    private EspecieService underTest;

    @BeforeEach
    void setUp() {
        underTest = new EspecieService(restTemplate);
    }
    @Test
    void testGetEpecies() {
        // Given
        EspecieDTO especie1 = new EspecieDTO();
        EspecieDTO especie2 = new EspecieDTO();
        EspecieListDTO especieListDTO = new EspecieListDTO();
        especieListDTO.setResults(Arrays.asList(especie1, especie2));

        when(restTemplate.getForObject("https://swapi.dev/api/species", EspecieListDTO.class)).thenReturn(especieListDTO);

        // When
        List<EspecieDTO> especies = underTest.getEpecies();

        // Then
        assertNotNull(especies);
        assertEquals(2, especies.size());
        verify(restTemplate).getForObject("https://swapi.dev/api/species", EspecieListDTO.class);
    }

    @Test
    void testSpecieDetails() {
        // Given
        Integer especieId = 1;
        EspecieDTO especie = new EspecieDTO();
        when(restTemplate.getForObject("https://swapi.dev/api/species/1", EspecieDTO.class)).thenReturn(especie);

        // Then
        EspecieDTO result = underTest.specieDetails(especieId);

        // Then
        assertNotNull(result);
        verify(restTemplate).getForObject("https://swapi.dev/api/species/1", EspecieDTO.class);
    }

    @Test
    void testSearchEspecieByName() {
        // Given
        String name = "Wookiee";
        EspecieDTO especie = new EspecieDTO();
        EspecieListDTO especieListDTO = new EspecieListDTO();
        especieListDTO.setResults(Arrays.asList(especie));

        when(restTemplate.getForObject("https://swapi.dev/api/species?search=Wookiee", EspecieListDTO.class)).thenReturn(especieListDTO);

        // Then
        List<EspecieDTO> results = underTest.searchEspecieByName(name);

        // Then
        assertNotNull(results);
        assertEquals(1, results.size());
        verify(restTemplate).getForObject("https://swapi.dev/api/species?search=Wookiee", EspecieListDTO.class);
    }

}