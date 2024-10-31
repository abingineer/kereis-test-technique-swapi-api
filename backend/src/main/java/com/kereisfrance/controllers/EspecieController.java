package com.kereisfrance.controllers;

import com.kereisfrance.dto.EspecieDTO;
import com.kereisfrance.services.EspecieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/especies")
public class EspecieController {
    private final EspecieService especieService;

    public EspecieController(EspecieService especieService) {
        this.especieService = especieService;
    }

    @Operation(summary = "Permet de d'obtenir la liste des espèces")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Obtention de la liste des films"
            ),
    })
    @GetMapping
    public ResponseEntity<List<EspecieDTO>> getEspecies() {
        List<EspecieDTO> especies =
                especieService.getEpecies();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(especies);
    }

    @Operation(summary = "Permet de rechercher une espèce par le nom")
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
    public ResponseEntity<List<EspecieDTO>> searchEspecieByName(@RequestParam(name = "name") String name) {
        List<EspecieDTO> especies = especieService.searchEspecieByName(name);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(especies);
    }
}
