package com.example.zlatik.service;

import com.example.zlatik.entity.Artist;
import com.example.zlatik.entity.Genre;
import com.example.zlatik.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    @Autowired
    ArtistRepository artistRepository;
    public List<Artist> getAll() {
        return artistRepository.findAll();
    }
    public Artist getById(Long id_artist) {
        return  artistRepository.findById(id_artist).orElse(null);
    }
    public void create(Artist artist) {
        artistRepository.save(artist);
    }
    public void delete(Long id_artist) {
        artistRepository.deleteById(id_artist);
    }
    public void update(Artist artist) {
        Artist artist1 = getById(artist.getId());
        artist1.setArtistName(artist.getArtistName());
        artistRepository.save(artist1);
    }
    public Artist getByArtistName(String artistName) {
        return artistRepository.findFirstByArtistName(artistName);
    }
}

