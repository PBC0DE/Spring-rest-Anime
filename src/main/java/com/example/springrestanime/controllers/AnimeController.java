package com.example.springrestanime.controllers;

import com.example.springrestanime.dtos.requests.CreateAnimeRequest;
import com.example.springrestanime.dtos.requests.UpdateAnimeRequest;
import com.example.springrestanime.dtos.responses.CreateAnimeResponse;
import com.example.springrestanime.dtos.responses.UpdateAnimeResponse;
import com.example.springrestanime.entities.Anime;
import com.example.springrestanime.entities.User;
import com.example.springrestanime.services.AnimeService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/anime")
@Api(tags = "AnimeController")
public class AnimeController {


    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @ApiOperation(value = "Get all anime", tags = "getAnimeAll", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully get list of all anime requested"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @GetMapping
    public List<Anime> getAnimeAll(
                             @ApiParam(value = "Search by anime fields: name, type, releasedate", example = "Manga")
                             @RequestParam(required = false, value = "search") String search) {
        return animeService.getAnimeAll(search);
    }

    @ApiOperation(value = "Get anime by id", tags = "getAnime", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully fetched anime record by id"),
            @ApiResponse(code = 404, message = "Anime ex ID not found error"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public Anime getAnime(@PathVariable("id") Long id) {
        return animeService.getAnime(id);
    }

    @ApiOperation(value = "Create Anime", tags = "createAnime", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully updated anime record"),
            @ApiResponse(code = 400, message = "Validation failed"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CreateAnimeResponse createAnime(
            @Valid @RequestBody CreateAnimeRequest createAnimeRequest,
            @AuthenticationPrincipal User user) {
        return new CreateAnimeResponse(animeService.createAnime(new Anime(createAnimeRequest), user));
    }

    @ApiOperation(value = "Update anime", tags = "updateAnime", httpMethod = "PUT")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created new anime record"),
            @ApiResponse(code = 400, message = "Validation failed"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public UpdateAnimeResponse updateAnime(@PathVariable("id") Long id, @Valid @RequestBody UpdateAnimeRequest updateAnimeRequest) {
        return new UpdateAnimeResponse(animeService.updateAnime(new Anime(id, updateAnimeRequest)));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Delete anime by id", tags = "deleteAnime", httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnime(@PathVariable("id") Long id) {
        animeService.deleteAnime(id);
    }
}
