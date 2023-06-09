package com.example.zlatik.service;

import com.example.zlatik.entity.Artist;
import com.example.zlatik.entity.Band;
import com.example.zlatik.entity.Joining;
import com.example.zlatik.repository.JoiningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoiningService {

    @Autowired
    JoiningRepository joiningRepository;
    @Autowired
    ArtistService artistService;
    @Autowired
    BandService bandService;
    public List<Joining> getAll() {
        return joiningRepository.findAll();
    }

    public Joining getById(Long id_join) {
        return joiningRepository.findById(id_join).orElse(null);
    }

    public void create(Joining joining) {
        joiningRepository.save(joining);
    }

    public void delete(Long id_join) {
        joiningRepository.deleteById(id_join);
    }

    public void update(Joining joining) {
        Joining joining1 = getById(joining.getId());
        Artist artist = artistService.getByArtistName(joining.getArtist().getArtistName());
        Band band = bandService.getByBandName(joining.getBand().getBandName());
        joining1.setArtist(artist);
        joining1.setBand(band);
        joining1.setJoinDate(joining.getJoinDate());
        joining1.setLeaveDate(joining.getLeaveDate());
        joiningRepository.save(joining1);
    }
}
