package com.kereisfrance.controllers;

import com.kereisfrance.dto.VehicleDTO;
import com.kereisfrance.services.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Operation(summary = "Permet de d'obtenir la liste des véhicules")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Obtention de la liste des véhicules"
            ),
    })
    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getVehicles() {
        List<VehicleDTO> vehicles =
                vehicleService.getVehicles();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vehicles);
    }

    @Operation(summary = "Permet de rechercher un véhicule par le nom")
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
    public ResponseEntity<List<VehicleDTO>> searchVehicleByName(@RequestParam(name = "name") String name) {
        List<VehicleDTO> vehicles = vehicleService.searchVehicleByName(name);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vehicles);
    }
}
