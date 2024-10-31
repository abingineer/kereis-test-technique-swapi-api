package com.kereisfrance.services;

import com.kereisfrance.dto.PeopleDTO;
import com.kereisfrance.dto.PeopleListDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PeopleService {
    private static final String SWAPI_URL = "https://swapi.dev/api/people";
    private final RestTemplate restTemplate;

    public PeopleService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<PeopleDTO> getPersonnages() {
        return restTemplate.getForObject(SWAPI_URL, PeopleListDTO.class).getResults();
    }

    public PeopleDTO detailsPersonnage(Integer id) {
        return restTemplate.getForObject(SWAPI_URL + "/"+id, PeopleDTO.class);
    }

    public List<PeopleDTO> rechercherParNom(String nom) {
        return restTemplate.getForObject(SWAPI_URL + "?search="+nom, PeopleListDTO.class).getResults();
    }
}
