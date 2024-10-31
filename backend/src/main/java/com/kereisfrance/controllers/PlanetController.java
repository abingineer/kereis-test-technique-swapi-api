package com.kereisfrance.controllers;

import com.kereisfrance.dto.PlanetDTO;
import com.kereisfrance.services.PlanetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/planets")
public class PlanetController {
    private final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @Operation(summary = "Permet de d'obtenir la liste des planètes")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Obtention de la liste des planètes"
            )
    })
    @GetMapping
    public ResponseEntity<List<PlanetDTO>> getPlanet() {
        List<PlanetDTO> persoonage =
                planetService.getPlanets();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(persoonage);
    }

    @Operation(summary = "Permet de rechercher une planète par le nom")
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
    public ResponseEntity<List<PlanetDTO>> searchByName(@RequestParam(name = "name") String name) {
        List<PlanetDTO> personnage = planetService.searchPlanetByName(name);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personnage);
    }
}
