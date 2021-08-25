package com.example.springrestanime.entities;

import com.example.springrestanime.dtos.requests.CreateAnimeRequest;
import com.example.springrestanime.dtos.requests.UpdateAnimeRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "anime")
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "type")
    private String type;

    @Column(name = "score")
    private Double score;

    @Column(name = "chapters")
    private Integer chapters;


    @Column(name = "releasedate")
    private String releasedate;

    @Column(name = "description")
    private String description;


    @CreationTimestamp
    @Column(name = "created")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "updated")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated;

    public Anime(Long id, String name, String image, String type, Double score, Integer chapters, String releasedate, String description, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.type = type;
        this.score = score;
        this.chapters = chapters;
        this.releasedate = releasedate;
        this.description = description;
        this.created = created;
        this.updated = updated;
    }

    public Anime(CreateAnimeRequest createAnimeRequest) {
        this.name = createAnimeRequest.getName();
        this.image = createAnimeRequest.getImage();
        this.type = createAnimeRequest.getType();
        this.score = createAnimeRequest.getScore();
        this.chapters = createAnimeRequest.getChapters();
        this.releasedate = createAnimeRequest.getReleasedate();
        this.description = createAnimeRequest.getDescription();
    }

    public Anime(Long id, UpdateAnimeRequest updateAnimeRequest) {
        this.id = id;
        this.name = updateAnimeRequest.getName();
        this.image = updateAnimeRequest.getImage();
        this.type = updateAnimeRequest.getType();
        this.score = updateAnimeRequest.getScore();
        this.chapters = updateAnimeRequest.getChapters();
        this.releasedate = updateAnimeRequest.getReleasedate();
        this.description = updateAnimeRequest.getDescription();
    }
}
