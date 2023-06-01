package com.example.zlatik.service;

import com.example.zlatik.entity.PerformsArtist;
import com.example.zlatik.repository.PerformsArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PerformsArtistService {
    @Autowired
    PerformsArtistRepository performsArtistRepository;
    @Async
    public List<PerformsArtist> getAllPerformsArtists() {
        return performsArtistRepository.findAll();
    }
    @Async
    public PerformsArtist getPerformsArtistByTitle(Integer id) {
        return performsArtistRepository.findById(id).orElse(null);
    }
    @Async
    public PerformsArtist createPerformsArtist(PerformsArtist performsArtist) {
        return performsArtistRepository.save(performsArtist);
    }
    @Async
    public void deletePerformsArtist(Integer id) {
        performsArtistRepository.deleteById(id);
    }
}
