package com.example.zlatik.service;

import com.example.zlatik.entity.ContainsArtist;
import com.example.zlatik.repository.ContainsArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContainsArtistService {

    @Autowired
    private ContainsArtistRepository containsArtistRepository;
    @Async
    public List<ContainsArtist> getAll() {
        return containsArtistRepository.findAll();
    }
    @Async
    public ContainsArtist getById(Long id_containsartist) {
        return containsArtistRepository.findById(id_containsartist).orElse(null);
    }
    @Async
    public void create(ContainsArtist containsArtist) {
        containsArtistRepository.save(containsArtist);
    }
    @Async
    public void delete(Long id_containsartist) {
        containsArtistRepository.deleteById(id_containsartist);
    }
    @Async
    public void update(ContainsArtist containsArtist) {
        ContainsArtist containsArtist1 = getById(containsArtist.getId());
        containsArtist1.setAlbum(containsArtist.getAlbum());
        containsArtist1.setArtist(containsArtist.getArtist());
        containsArtistRepository.save(containsArtist1);
    }
}

