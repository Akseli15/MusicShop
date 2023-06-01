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
    ContainsArtistRepository containsArtistRepository;
    @Async
    public List<ContainsArtist> getAllContainsArtists() {
        return containsArtistRepository.findAll();
    }
    @Async
    public ContainsArtist getContainsArtistByTitle(Integer id) {
        return containsArtistRepository.findById(id).orElse(null);
    }
    @Async
    public ContainsArtist createContainsArtist(ContainsArtist containsArtist) {
        return containsArtistRepository.save(containsArtist);
    }
    @Async
    public void deleteContainsArtist(Integer id) {
        containsArtistRepository.deleteById(id);
    }
}

