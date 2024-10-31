package com.kereisfrance.controllers;

import com.kereisfrance.dto.StarshipDTO;
import com.kereisfrance.services.StarshipService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/starships")
public class StarshipController {
    private final StarshipService starshipService;

    public StarshipController(StarshipService starshipService) {
        this.starshipService = starshipService;
    }

    @Operation(summary = "Permet de d'obtenir la liste des vaisseaux spatiaux")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Obtention de la liste des vaisseaux"
            )
    })
    @GetMapping
    public ResponseEntity<List<StarshipDTO>> getEspecies() {
        List<StarshipDTO> starships =
                starshipService.getStarships();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(starships);
    }
    @Operation(summary = "Permet de rechercher une vaisseau spatial par le nom")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Résultat de la recherche"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Erreur dans lors de la construction de la requête",
                    content = @Content
            )
    })
    @GetMapping("search")
    public ResponseEntity<List<StarshipDTO>> searchEspecieByName(@RequestParam(name = "name") String name) {
        List<StarshipDTO> starships = starshipService.searchStarshipByName(name);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(starships);
    }
}
