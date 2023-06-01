package com.example.zlatik.service;

import com.example.zlatik.entity.Artist;
import com.example.zlatik.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArtistService {
    @Autowired
    ArtistRepository artistRepository;
    @Async
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }
    @Async
    public Artist getArtistByTitle(String title) {
        return artistRepository.findById(title).orElse(null);
    }
    @Async
    public Artist createArtist(Artist artist) {
        return artistRepository.save(artist);
    }
    @Async
    public void deleteArtist(String title) {
        artistRepository.deleteById(title);
    }
}


