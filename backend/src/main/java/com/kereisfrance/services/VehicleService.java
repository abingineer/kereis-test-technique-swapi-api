package com.kereisfrance.services;

import com.kereisfrance.dto.VehicleDTO;
import com.kereisfrance.dto.VehicleListDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class VehicleService {
    private static final String SWAPI_URL = "https://swapi.dev/api/vehicles";
    private final RestTemplate restTemplate;

    public VehicleService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<VehicleDTO> getVehicles() {
        return restTemplate.getForObject(SWAPI_URL, VehicleListDTO.class).getResults();
    }

    public VehicleDTO vehicleDetails(Integer id) {
        return restTemplate.getForObject(SWAPI_URL + "/"+id, VehicleDTO.class);
    }

    public List<VehicleDTO> searchVehicleByName(String name) {
        return restTemplate.getForObject(SWAPI_URL + "?search="+name, VehicleListDTO.class).getResults();
    }
}
