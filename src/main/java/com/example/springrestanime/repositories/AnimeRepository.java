package com.example.springrestanime.repositories;

import com.example.springrestanime.entities.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {


    @Query("FROM Anime x WHERE UPPER(x.name) LIKE UPPER(CONCAT('%', :search, '%')) " +
            "OR UPPER(x.releasedate) LIKE UPPER(CONCAT('%', :search, '%')) OR UPPER(x.type) LIKE UPPER(CONCAT('%', :search, '%'))")
    List<Anime> searchAnime(@Param("search") String search);


}
