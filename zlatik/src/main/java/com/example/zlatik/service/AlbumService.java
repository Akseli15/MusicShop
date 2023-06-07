package com.example.zlatik.service;

import com.example.zlatik.entity.Album;
import com.example.zlatik.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> getAll() {
        return albumRepository.findAll();
    }

    public Album getById(Long id_album) {
        return  albumRepository.findById(id_album).orElse(null);
    }

    public void create(Album album) {
        albumRepository.save(album);
    }
    public void delete(Long id_album) {
        albumRepository.deleteById(id_album);
    }

    public void update(Album album) {
        Album album1 = getById(album.getId());
        album1.setAlbumName(album.getAlbumName());
        album1.setAlbumDuration(album.getAlbumDuration());
        album1.setReleaseDate(album.getReleaseDate());
        albumRepository.save(album1);
    }
}