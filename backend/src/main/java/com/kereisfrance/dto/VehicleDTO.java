package com.kereisfrance.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class VehicleDTO extends StarshipDTO{
    @JsonAlias("vehicle_class")
    public String vehicleClass;
}
