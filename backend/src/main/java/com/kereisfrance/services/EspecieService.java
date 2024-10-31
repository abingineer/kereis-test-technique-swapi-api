package com.kereisfrance.services;

import com.kereisfrance.dto.EspecieDTO;
import com.kereisfrance.dto.EspecieListDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EspecieService {
    private static final String SWAPI_URL = "https://swapi.dev/api/species";
    private final RestTemplate restTemplate;

    public EspecieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<EspecieDTO> getEpecies() {
        return restTemplate.getForObject(SWAPI_URL, EspecieListDTO.class).getResults();
    }

    public EspecieDTO specieDetails(Integer id) {
        return restTemplate.getForObject(SWAPI_URL + "/"+id, EspecieDTO.class);
    }

    public List<EspecieDTO> searchEspecieByName(String name) {
        return restTemplate.getForObject(SWAPI_URL + "?search="+name, EspecieListDTO.class).getResults();
    }
}
