package com.kereisfrance.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarshipDTO {
    public String name;
    public String model;
    public String manufacturer;
    @JsonAlias("cost_in_credits")
    public String costInCredits;
    public String length;
    @JsonAlias("max_atmosphering_speed")
    public String maxAtmospheringSpeed;
    public String crew;
    public String passengers;
    @JsonAlias("cargo_capacity")
    public String cargoCapacity;
    @JsonAlias("starship_class")
    public String starshipClass;
    public String consumables;

}
