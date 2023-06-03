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
    public Album getAlbumById(String id) {
        return albumRepository.findById(id).orElse(null);
    }
    @Async
    public void createAlbum(Album album) {
        albumRepository.save(album);
        System.out.println("Create new empty object");
    }
    @Async
    public void deleteAlbum(String title) {
        albumRepository.deleteById(title);
    }
    @Async
    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }
}
