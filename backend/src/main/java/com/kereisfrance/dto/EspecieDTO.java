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
public class EspecieDTO {
    public String name;
    public String classification;
    public String designation;
    @JsonAlias("average_height")
    public String averageHeight;
    @JsonAlias("skin_colors")
    public String skinColors;
    @JsonAlias("hair_colors")
    public String hairColors;
    @JsonAlias("eye_colors")
    public String eyeColors;
    @JsonAlias("average_lifespan")
    public String averageLifespan;
    public String homeworld;
    public String language;
}
