package com.kereisfrance.services;

import com.kereisfrance.dto.StarshipDTO;
import com.kereisfrance.dto.StarshipListDTO;
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
class StarshipServiceTest {

    @Mock
    private RestTemplate restTemplate;
    private StarshipService underTest;

    private static final String SWAPI_URL = "https://swapi.dev/api/starships";

    @BeforeEach
    public void setUp() {
        underTest = new StarshipService(restTemplate);
    }

    @Test
    public void testGetStarships() {
        // Given
        StarshipListDTO mockResponse = new StarshipListDTO();
        mockResponse.setResults(Collections.singletonList(new StarshipDTO())); // Add mock StarshipDTO
        when(restTemplate.getForObject(SWAPI_URL, StarshipListDTO.class)).thenReturn(mockResponse);

        // Act
        List<StarshipDTO> result = underTest.getStarships();

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(restTemplate, times(1)).getForObject(SWAPI_URL, StarshipListDTO.class);
    }

    @Test
    public void testStarshipDetails() {
        // Given
        Integer id = 1;
        StarshipDTO mockResponse = new StarshipDTO();
        when(restTemplate.getForObject(SWAPI_URL + "/" + id, StarshipDTO.class)).thenReturn(mockResponse);

        // When
        StarshipDTO result = underTest.starshipDetails(id);

        // Then
        assertNotNull(result);
        verify(restTemplate, times(1)).getForObject(SWAPI_URL + "/" + id, StarshipDTO.class);
    }

    @Test
    public void testSearchStarshipByName() {
        // Given
        String name = "Millennium Falcon";
        StarshipListDTO mockResponse = new StarshipListDTO();
        mockResponse.setResults(Collections.singletonList(new StarshipDTO())); // Add mock StarshipDTO
        when(restTemplate.getForObject(SWAPI_URL + "?search=" + name, StarshipListDTO.class)).thenReturn(mockResponse);

        // When
        List<StarshipDTO> result = underTest.searchStarshipByName(name);

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(restTemplate, times(1)).getForObject(SWAPI_URL + "?search=" + name, StarshipListDTO.class);
    }

}