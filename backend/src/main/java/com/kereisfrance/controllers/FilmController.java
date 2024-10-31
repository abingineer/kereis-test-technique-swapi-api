package com.kereisfrance.controllers;

import com.kereisfrance.dto.FilmDTO;
import com.kereisfrance.services.FilmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/films")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @Operation(summary = "Permet d'obtenir la liste des films")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lite des films"
            )
    })
    @GetMapping
    public ResponseEntity<List<FilmDTO>> listeFilms() {
        List<FilmDTO> films =
                filmService.getFilms();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(films);
    }

    @Operation(summary = "Permet de rechercher un film par le titre")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Résultat de la recherche"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Erreur dans lors de la construction de la requête",
                    content = @Content
            ),
    })
    @GetMapping("search")
    public ResponseEntity<List<FilmDTO>> searcheFilmByTitle(@RequestParam(name = "title") String title) {
        List<FilmDTO> film = filmService.searchFilmByTitle(title);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(film);
    }
}
