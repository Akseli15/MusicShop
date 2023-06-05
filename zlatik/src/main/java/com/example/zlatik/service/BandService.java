package com.example.zlatik.service;

import com.example.zlatik.entity.Band;
import com.example.zlatik.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandService {

    @Autowired
    private BandRepository bandRepository;
    @Async
    public List<Band> getAll() {
        return bandRepository.findAll();
    }
    @Async
    public Band getById(Long id_band) {
        return bandRepository.findById(id_band).orElse(null);
    }
    @Async
    public void create(Band band) {
        bandRepository.save(band);
    }
    @Async
    public void delete(Long id_band) {
        bandRepository.deleteById(id_band);
    }
    @Async
    public void update(Band band) {
        Band band1 = getById(band.getId());
        band1.setBandName(band.getBandName());
        bandRepository.save(band1);
    }
}