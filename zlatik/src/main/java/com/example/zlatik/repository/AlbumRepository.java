package com.example.zlatik.repository;

import com.example.zlatik.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long>{
}
