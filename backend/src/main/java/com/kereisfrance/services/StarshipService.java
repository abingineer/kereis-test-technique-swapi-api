package com.kereisfrance.services;

import com.kereisfrance.dto.StarshipDTO;
import com.kereisfrance.dto.StarshipListDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StarshipService {
    private static final String SWAPI_URL = "https://swapi.dev/api/starships";
    private final RestTemplate restTemplate;

    public StarshipService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<StarshipDTO> getStarships() {
        return restTemplate.getForObject(SWAPI_URL, StarshipListDTO.class).getResults();
    }

    public StarshipDTO starshipDetails(Integer id) {
        return restTemplate.getForObject(SWAPI_URL + "/"+id, StarshipDTO.class);
    }

    public List<StarshipDTO> searchStarshipByName(String name) {
        return restTemplate.getForObject(SWAPI_URL + "?search="+name, StarshipListDTO.class).getResults();
    }
}
