package com.example.springrestanime.services;

import com.example.springrestanime.entities.Anime;
import com.example.springrestanime.entities.User;
import com.example.springrestanime.exceptions.ResourceNotFoundException;
import com.example.springrestanime.repositories.AnimeRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {

    private final UserService userService;

    private final AnimeRepository animeRepository;

    public AnimeService(UserService userService, AnimeRepository animeRepository) {
        this.userService = userService;
        this.animeRepository = animeRepository;
    }

    public List<Anime> getAnimeAll(String search) {
        if (search == null) {
            return animeRepository.findAll();
        } else {
            return animeRepository.searchAnime(search);
        }
    }

    public Anime getAnime(Long id) {
        Anime anime = animeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
            return anime;
    }
    public Anime createAnime(Anime anime, User user) {
        return animeRepository.save(anime);
    }

    public Anime updateAnime(Anime updatedAnime) {
        return animeRepository.save(updatedAnime);
    }


    public void deleteAnime(Long id) {
        animeRepository.deleteById(getAnime(id).getId());
    }
}
