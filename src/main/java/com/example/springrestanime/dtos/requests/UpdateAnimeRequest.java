package com.example.springrestanime.dtos.requests;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class UpdateAnimeRequest {


    @NotBlank
    private final String name;

    @NotBlank
    private final String image;

    @NotNull
    private final String type;

    @NotNull
    private final Double score;

    @NotNull
    private final Integer chapters;

    private final String releasedate;

    @NotBlank
    private final String description;
}
