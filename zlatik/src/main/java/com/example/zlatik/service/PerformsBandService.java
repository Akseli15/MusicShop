package com.example.zlatik.service;

import com.example.zlatik.entity.PerformsBand;
import com.example.zlatik.repository.PerformsBandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PerformsBandService {

    @Autowired
    private PerformsBandRepository performsBandRepository;

    public List<PerformsBand> getAll() {
        return performsBandRepository.findAll();
    }

    public PerformsBand getById(Long id_performsband) {
        return performsBandRepository.findById(id_performsband).orElse(null);
    }

    public void create(PerformsBand performsBand) {
        performsBandRepository.save(performsBand);
    }

    public void delete(Long id_performsband) {
        performsBandRepository.deleteById(id_performsband);
    }

    public void update(PerformsBand performsBand) {
        PerformsBand performsBand1 = getById(performsBand.getId());
        performsBand1.setBand(performsBand.getBand());
        performsBand1.setSong(performsBand.getSong());
        performsBandRepository.save(performsBand1);
    }
}
