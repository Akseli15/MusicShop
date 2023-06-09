package com.example.zlatik.service;

import com.example.zlatik.entity.Album;
import com.example.zlatik.entity.Artist;
import com.example.zlatik.entity.Band;
import com.example.zlatik.entity.ContainsBand;
import com.example.zlatik.repository.ContainsBandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContainsBandService {

    @Autowired
    ContainsBandRepository containsBandRepository;
    @Autowired
    AlbumService albumService;
    @Autowired
    BandService bandService;

    public List<ContainsBand> getAll() {
        return containsBandRepository.findAll();
    }

    public ContainsBand getById(Long id_containsband) {
        return containsBandRepository.findById(id_containsband).orElse(null);
    }

    public void create(ContainsBand containsBand) {
        containsBandRepository.save(containsBand);
    }

    public void delete(Long id_containsband) {
        containsBandRepository.deleteById(id_containsband);
    }

    public void update(ContainsBand containsBand) {
        ContainsBand containsBand1 = getById(containsBand.getId());
        Album album = albumService.getByAlbumName(containsBand.getAlbum().getAlbumName());
        Band band = bandService.getByBandName(containsBand.getBand().getBandName());
        containsBand1.setAlbum(album);
        containsBand1.setBand(band);
        containsBandRepository.save(containsBand1);
    }
}
