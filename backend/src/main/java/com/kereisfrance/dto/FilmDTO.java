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
public class FilmDTO {
    public String title;
    @JsonAlias("episode_id")
    public int episodeId;
    @JsonAlias("opening_crawl")
    public String openingCrawl;
    public String director;
    public String producer;
    @JsonAlias("release_date")
    public String releaseDate;
}
