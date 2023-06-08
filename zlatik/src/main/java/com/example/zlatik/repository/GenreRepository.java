package com.example.zlatik.repository;

import com.example.zlatik.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findFirstByGenreName(String genreName);
}
