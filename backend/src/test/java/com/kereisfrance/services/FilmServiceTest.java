package com.kereisfrance.services;

import com.kereisfrance.dto.FilmDTO;
import com.kereisfrance.dto.FilmsDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class FilmServiceTest {

   @Mock
   private RestTemplate restTemplate;
   private FilmService underTest;

    @BeforeEach
    void setUp() {
        underTest = new FilmService(restTemplate);
    }

    @Test
    void testGetFilms() {
        // Given
        FilmDTO film1 = new FilmDTO();
        FilmDTO film2 = new FilmDTO();
        FilmsDTO filmsDTO = new FilmsDTO();
        filmsDTO.setResults(Arrays.asList(film1, film2));

        when(restTemplate.getForObject("https://swapi.dev/api/films", FilmsDTO.class)).thenReturn(filmsDTO);
        // When
        List<FilmDTO> films = underTest.getFilms();

        // Then
        assertNotNull(films);
        assertEquals(2, films.size());
        verify(restTemplate).getForObject("https://swapi.dev/api/films", FilmsDTO.class);
    }

    @Test
    void testFilmDetails() {
        // Given
        Integer filmId = 1;
        FilmDTO film = new FilmDTO();
        when(restTemplate.getForObject("https://swapi.dev/api/films/1", FilmDTO.class)).thenReturn(film);

        // When
        FilmDTO result = underTest.filmDetails(filmId);

        // Then
        assertNotNull(result);
        verify(restTemplate).getForObject("https://swapi.dev/api/films/1", FilmDTO.class);
    }

    @Test
    void testSearchFilmByTitle() {
        // Given
        String titre = "A New Hope";
        FilmDTO film = new FilmDTO();
        FilmsDTO filmsDTO = new FilmsDTO();
        filmsDTO.setResults(Arrays.asList(film));

        when(restTemplate.getForObject("https://swapi.dev/api/films/?search=A New Hope", FilmsDTO.class)).thenReturn(filmsDTO);

        // When
        List<FilmDTO> results = underTest.searchFilmByTitle(titre);

        // Then
        assertNotNull(results);
        assertEquals(1, results.size());
        verify(restTemplate).getForObject("https://swapi.dev/api/films/?search=A New Hope", FilmsDTO.class);
    }
}