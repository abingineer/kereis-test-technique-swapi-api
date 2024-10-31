package com.kereisfrance.services;

import com.kereisfrance.dto.FilmDTO;
import com.kereisfrance.dto.FilmsDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FilmService {
    private static final String SWAPI_URL = "https://swapi.dev/api/films";
    private final RestTemplate restTemplate;

    public FilmService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<FilmDTO>  getFilms() {
        return restTemplate.getForObject(SWAPI_URL, FilmsDTO.class).getResults();
    }

    public FilmDTO filmDetails(Integer id) {
        return restTemplate.getForObject(SWAPI_URL + "/"+id, FilmDTO.class);
    }

    public List<FilmDTO> searchFilmByTitle(String title) {
        return restTemplate.getForObject(String.format("%s/?search=%s", SWAPI_URL, title), FilmsDTO.class).getResults();
    }
}
