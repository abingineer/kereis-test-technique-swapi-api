package com.kereisfrance.services;

import com.kereisfrance.dto.PlanetDTO;
import com.kereisfrance.dto.PlanetsDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlanetServiceTest {
    @Mock
    private RestTemplate restTemplate;
    private PlanetService underTest;

    private static final String SWAPI_URL = "https://swapi.dev/api/planets";

    @BeforeEach
    public void setUp() {
        underTest = new PlanetService(restTemplate);
    }

    @Test
    public void testGetPlanets() {
        // Given
        PlanetsDTO mockResponse = new PlanetsDTO();
        mockResponse.setResults(Collections.singletonList(new PlanetDTO())); // Add mock PlanetDTO
        when(restTemplate.getForObject(SWAPI_URL, PlanetsDTO.class)).thenReturn(mockResponse);

        // When
        List<PlanetDTO> result = underTest.getPlanets();

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(restTemplate, times(1)).getForObject(SWAPI_URL, PlanetsDTO.class);
    }

    @Test
    public void testPlanetDetails() {
        // Given
        Integer id = 1;
        PlanetDTO mockResponse = new PlanetDTO();
        when(restTemplate.getForObject(SWAPI_URL + "/" + id, PlanetDTO.class)).thenReturn(mockResponse);

        // When
        PlanetDTO result = underTest.planetDetails(id);

        // Then
        assertNotNull(result);
        verify(restTemplate, times(1)).getForObject(SWAPI_URL + "/" + id, PlanetDTO.class);
    }

    @Test
    public void testSearchPlanetByName() {
        // Given
        String name = "Tatooine";
        PlanetsDTO mockResponse = new PlanetsDTO();
        mockResponse.setResults(Collections.singletonList(new PlanetDTO())); // Add mock PlanetDTO
        when(restTemplate.getForObject(SWAPI_URL + "?search=" + name, PlanetsDTO.class)).thenReturn(mockResponse);

        // When
        List<PlanetDTO> result = underTest.searchPlanetByName(name);

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(restTemplate, times(1)).getForObject(SWAPI_URL + "?search=" + name, PlanetsDTO.class);
    }

}