package com.kereisfrance.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanetDTO {
    public String name;
    @JsonAlias("rotation_period")
    public String rotationPeriod;
    @JsonAlias("orbital_period")
    public String orbitalPeriod;
    public String diameter;
    public String climate;
    public String gravity;
    public String terrain;
    @JsonAlias("surface_water")
    public String surfaceWater;
    public String population;
}
