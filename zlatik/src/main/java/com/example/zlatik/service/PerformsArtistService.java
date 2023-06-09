package com.example.zlatik.service;

import com.example.zlatik.entity.*;
import com.example.zlatik.repository.PerformsArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PerformsArtistService {

    @Autowired
    PerformsArtistRepository performsArtistRepository;
    @Autowired
    SongService songService;
    @Autowired
    ArtistService artistService;

    public List<PerformsArtist> getAll() {
        return performsArtistRepository.findAll();
    }

    public PerformsArtist getById(Long id_performsartist) {
        return performsArtistRepository.findById(id_performsartist).orElse(null);
    }

    public void create(PerformsArtist performsArtist) {
        performsArtistRepository.save(performsArtist);
    }

    public void delete(Long id_performsartist) {
        performsArtistRepository.deleteById(id_performsartist);
    }

    public void update(PerformsArtist performsArtist) {
        PerformsArtist performsArtist1 = getById(performsArtist.getId());
        Artist artist = artistService.getByArtistName(performsArtist.getArtist().getArtistName());
        Song song = songService.getBySongName(performsArtist.getSong().getSongName());
        performsArtist1.setArtist(artist);
        performsArtist1.setSong(song);
        performsArtistRepository.save(performsArtist1);
    }
}
