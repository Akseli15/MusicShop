package com.example.zlatik.repository;

import com.example.zlatik.entity.Album;
import com.example.zlatik.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long>{
    Album findFirstByAlbumName(String albumName);
}
