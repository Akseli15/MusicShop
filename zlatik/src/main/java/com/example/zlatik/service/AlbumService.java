package com.example.zlatik.service;

import com.example.zlatik.entity.Album;
import com.example.zlatik.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    AlbumRepository albumRepository;
    @Async
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }
    @Async
    public Album getAlbumByTitle(String title) {
        return albumRepository.findById(title).orElse(null);
    }
    @Async
    public Album createAlbum(Album album) {
        return albumRepository.save(album);
    }
    @Async
    public void deleteAlbum(String title) {
        albumRepository.deleteById(title);
    }
}
