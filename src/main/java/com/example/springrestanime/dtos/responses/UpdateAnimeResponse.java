package com.example.springrestanime.dtos.responses;

import com.example.springrestanime.entities.Anime;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateAnimeResponse {

    private final Long id;

    private final String name;

    private final String image;

    private String type;

    private Double score;

    private Integer chapters;

    private final String releasedate;

    private final String description;

    private final LocalDateTime created;

    private final LocalDateTime updated;

    public UpdateAnimeResponse(Anime anime) {
        this.id = anime.getId();
        this.name = anime.getName();
        this.image = anime.getImage();
        this.type = anime.getType();
        this.score = anime.getScore();
        this.chapters = anime.getChapters();
        this.releasedate = anime.getReleasedate();
        this.description = anime.getDescription();
        this.created = anime.getCreated();
        this.updated = anime.getUpdated();
    }
}
