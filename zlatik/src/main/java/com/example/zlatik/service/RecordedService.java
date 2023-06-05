package com.example.zlatik.service;

import com.example.zlatik.entity.Recorded;
import com.example.zlatik.repository.RecordedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordedService {

    @Autowired
    private RecordedRepository recordedRepository;
    @Async
    public List<Recorded> getAll() {
        return recordedRepository.findAll();
    }
    @Async
    public Recorded getById(Long id_recorded) {
        return recordedRepository.findById(id_recorded).orElse(null);
    }
    @Async
    public void create(Recorded recorded) {
        recordedRepository.save(recorded);
    }
    @Async
    public void delete(Long id_recorded) {
        recordedRepository.deleteById(id_recorded);
    }
    @Async
    public void update(Recorded recorded) {
        Recorded recorded1 = getById(recorded.getId());
        recorded1.setAlbum(recorded.getAlbum());
        recorded1.setRecordedCost(recorded.getRecordedCost());
        recorded1.setCarrier(recorded.getCarrier());
        recordedRepository.save(recorded1);
    }
}
