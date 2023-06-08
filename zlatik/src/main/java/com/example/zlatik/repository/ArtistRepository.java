package com.example.zlatik.repository;

import com.example.zlatik.entity.Artist;
import com.example.zlatik.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Artist findFirstByArtistName(String artistName);
}
