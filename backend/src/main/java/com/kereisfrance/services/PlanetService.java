package com.kereisfrance.services;

import com.kereisfrance.dto.PlanetDTO;
import com.kereisfrance.dto.PlanetsDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PlanetService {
    private static final String SWAPI_URL = "https://swapi.dev/api/planets";
    private final RestTemplate restTemplate;

    public PlanetService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<PlanetDTO> getPlanets() {
        return restTemplate.getForObject(SWAPI_URL, PlanetsDTO.class).getResults();
    }

    public PlanetDTO planetDetails(Integer id) {
        return restTemplate.getForObject(SWAPI_URL + "/"+id, PlanetDTO.class);
    }

    public List<PlanetDTO> searchPlanetByName(String name) {
        return restTemplate.getForObject(SWAPI_URL + "?search="+name, PlanetsDTO.class).getResults();
    }
}
