package com.example.zlatik.repository;

import com.example.zlatik.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
    Song findFirstBySongName(String songName);
}
