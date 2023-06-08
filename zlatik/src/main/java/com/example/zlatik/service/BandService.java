package com.example.zlatik.service;

import com.example.zlatik.entity.Band;
import com.example.zlatik.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandService {

    @Autowired
    BandRepository bandRepository;

    public List<Band> getAll() {
        return bandRepository.findAll();
    }
    public Band getById(Long id_band) {
        return bandRepository.findById(id_band).orElse(null);
    }
    public void create(Band band) {
        bandRepository.save(band);
    }
    public void delete(Long id_band) {
        bandRepository.deleteById(id_band);
    }
    public void update(Band band) {
        Band band1 = getById(band.getId());
        band1.setBandName(band.getBandName());
        bandRepository.save(band1);
    }
    public Band getByBandName(String bandName) {
        return bandRepository.findFirstByBandName(bandName);
    }
}