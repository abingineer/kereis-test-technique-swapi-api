package com.kereisfrance.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeopleDTO {
    public String name;
    public String height;
    public String mass;
    @JsonAlias("hair_color")
    public String hairColor;
    @JsonAlias("skin_color")
    public String skinColor;
    @JsonAlias("eye_color")
    public String eyeColor;
    @JsonAlias("birth_year")
    public String birthYear;
    public String gender;
    public String homeworld;
}
