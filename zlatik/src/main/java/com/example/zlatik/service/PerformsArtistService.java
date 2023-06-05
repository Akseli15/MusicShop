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
    private PerformsArtistRepository performsArtistRepository;
    @Async
    public List<PerformsArtist> getAll() {
        return performsArtistRepository.findAll();
    }
    @Async
    public PerformsArtist getById(Long id_performsartist) {
        return performsArtistRepository.findById(id_performsartist).orElse(null);
    }
    @Async
    public void create(PerformsArtist performsArtist) {
        performsArtistRepository.save(performsArtist);
    }
    @Async
    public void delete(Long id_performsartist) {
        performsArtistRepository.deleteById(id_performsartist);
    }
    @Async
    public void update(PerformsArtist performsArtist) {
        PerformsArtist performsArtist1 = getById(performsArtist.getId());
        performsArtist1.setArtist(performsArtist.getArtist());
        performsArtist1.setSong(performsArtist.getSong());
        performsArtistRepository.save(performsArtist1);
    }
}
