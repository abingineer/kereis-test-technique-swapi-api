package com.kereisfrance.services;

import com.kereisfrance.dto.PeopleDTO;
import com.kereisfrance.dto.PeopleListDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class PeopleServiceTest {

    @Mock
    private RestTemplate restTemplate;
    private PeopleService peopleService;

    private static final String SWAPI_URL = "https://swapi.dev/api/people";

    @BeforeEach
    public void setUp() {
        peopleService = new PeopleService(restTemplate);
    }

    @Test
    public void testGetPersonnages() {
        // Given
        PeopleListDTO mockResponse = new PeopleListDTO();
        mockResponse.setResults(Collections.singletonList(new PeopleDTO())); // Add mock PersonnageDTO
        when(restTemplate.getForObject(SWAPI_URL, PeopleListDTO.class)).thenReturn(mockResponse);

        // Act
        List<PeopleDTO> result = peopleService.getPersonnages();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(restTemplate, times(1)).getForObject(SWAPI_URL, PeopleListDTO.class);
    }

    @Test
    public void testDetailsPersonnage() {
        // Given
        Integer id = 1;
        PeopleDTO mockResponse = new PeopleDTO();
        when(restTemplate.getForObject(SWAPI_URL + "/" + id, PeopleDTO.class)).thenReturn(mockResponse);

        // Act
        PeopleDTO result = peopleService.detailsPersonnage(id);

        // Assert
        assertNotNull(result);
        verify(restTemplate, times(1)).getForObject(SWAPI_URL + "/" + id, PeopleDTO.class);
    }

    @Test
    public void testRechercherParNom() {
        // Given
        String nom = "Luke";
        PeopleListDTO mockResponse = new PeopleListDTO();
        mockResponse.setResults(Collections.singletonList(new PeopleDTO())); // Add mock PersonnageDTO
        when(restTemplate.getForObject(SWAPI_URL + "?search=" + nom, PeopleListDTO.class)).thenReturn(mockResponse);

        // When
        List<PeopleDTO> result = peopleService.rechercherParNom(nom);

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(restTemplate, times(1)).getForObject(SWAPI_URL + "?search=" + nom, PeopleListDTO.class);
    }
}
