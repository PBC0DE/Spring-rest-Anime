package com.example.springrestanime.dtos.requests;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
public class CreateAnimeRequest {

    @NotBlank
    @ApiModelProperty(notes = "Anime name", required = true, name = "name", value = "Death NOTE", example = "Death NOTE")
    private final String name;

    @NotBlank
    @ApiModelProperty(notes = "Anime image art", required = true, name = "image", value = "httplink", example = "httplink")
    private final String image;

    @NotNull
    @ApiModelProperty(notes = "type of anime", required = true, name = "manga", value = "manga", example = "manga")
    private final String type;

    @NotNull
    @ApiModelProperty(notes = "Anime average score", required = true, name = "score", value = "7.7", example = "7.7")
    private final Double score;

    @NotNull
    @ApiModelProperty(notes = "how much episodes", required = true, name = "chapters", value = "100", example = "100")
    private final Integer chapters;

    @ApiModelProperty(notes = "anime release date", required = true, name = "releasedate", value = "december 5th", example = "december 5th")
    private final String releasedate;


    @NotBlank
    private final String description;

}
