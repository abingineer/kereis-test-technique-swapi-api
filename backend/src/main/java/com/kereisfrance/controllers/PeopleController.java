package com.kereisfrance.controllers;

import com.kereisfrance.dto.PeopleDTO;
import com.kereisfrance.services.PeopleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/people")
public class PeopleController {
    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Operation(summary = "Permet de d'obtenir la liste de personnages")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Obtention de la liste de personnages"
            )
    })
    @GetMapping
    public ResponseEntity<List<PeopleDTO>> getPeople() {
        List<PeopleDTO> persoonage =
               peopleService.getPersonnages();
       return ResponseEntity
               .status(HttpStatus.OK)
               .body(persoonage);
    }

    @Operation(summary = "Permet de rechercher un personnage par le nom")
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
    public ResponseEntity<List<PeopleDTO>> searchPeopleByName(@RequestParam(name = "name") String name) {
        List<PeopleDTO> personnage = peopleService.rechercherParNom(name);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personnage);
    }
}

