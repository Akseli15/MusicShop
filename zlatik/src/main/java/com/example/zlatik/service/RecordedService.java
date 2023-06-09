package com.example.zlatik.service;

import com.example.zlatik.entity.Album;
import com.example.zlatik.entity.Carrier;
import com.example.zlatik.entity.Recorded;
import com.example.zlatik.repository.RecordedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordedService {

    @Autowired
    RecordedRepository recordedRepository;
    @Autowired
    AlbumService albumService;
    @Autowired
    CarrierService carrierService;

    public List<Recorded> getAll() {
        return recordedRepository.findAll();
    }

    public Recorded getById(Long id_recorded) {
        return recordedRepository.findById(id_recorded).orElse(null);
    }

    public void create(Recorded recorded) {
        recordedRepository.save(recorded);
    }

    public void delete(Long id_recorded) {
        recordedRepository.deleteById(id_recorded);
    }

    public void update(Recorded recorded) {
        Recorded recorded1 = getById(recorded.getId());
        Album album = albumService.getByAlbumName(recorded.getAlbum().getAlbumName());
        Carrier carrier = carrierService.getById(recorded.getCarrier().getId());
        recorded1.setAlbum(album);
        recorded1.setCarrier(carrier);
        recorded1.setRecordedCost(recorded.getRecordedCost());
        recordedRepository.save(recorded1);
    }
}
