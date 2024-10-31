package com.kereisfrance.services;

import com.kereisfrance.dto.VehicleDTO;
import com.kereisfrance.dto.VehicleListDTO;
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
class VehicleServiceTest {
    @Mock
    private RestTemplate restTemplate;
    private VehicleService underTest;

    private static final String SWAPI_URL = "https://swapi.dev/api/vehicles";

    @BeforeEach
    public void setUp() {
        underTest = new VehicleService(restTemplate);
    }

    @Test
    public void testGetVehicles() {
        // Given
        VehicleListDTO mockResponse = new VehicleListDTO();
        mockResponse.setResults(Collections.singletonList(new VehicleDTO())); // Add mock VehicleDTO
        when(restTemplate.getForObject(SWAPI_URL, VehicleListDTO.class)).thenReturn(mockResponse);

        // When
        List<VehicleDTO> result = underTest.getVehicles();

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(restTemplate, times(1)).getForObject(SWAPI_URL, VehicleListDTO.class);
    }

    @Test
    public void testVehicleDetails() {
        // Given
        Integer id = 1;
        VehicleDTO mockResponse = new VehicleDTO();
        when(restTemplate.getForObject(SWAPI_URL + "/" + id, VehicleDTO.class)).thenReturn(mockResponse);

        // When
        VehicleDTO result = underTest.vehicleDetails(id);

        // Then
        assertNotNull(result);
        verify(restTemplate, times(1)).getForObject(SWAPI_URL + "/" + id, VehicleDTO.class);
    }

    @Test
    public void testSearchVehicleByName() {
        // Given
        String name = "Speeder";
        VehicleListDTO mockResponse = new VehicleListDTO();
        mockResponse.setResults(Collections.singletonList(new VehicleDTO())); // Add mock VehicleDTO
        when(restTemplate.getForObject(SWAPI_URL + "?search=" + name, VehicleListDTO.class)).thenReturn(mockResponse);

        // When
        List<VehicleDTO> result = underTest.searchVehicleByName(name);

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(restTemplate, times(1)).getForObject(SWAPI_URL + "?search=" + name, VehicleListDTO.class);
    }
}