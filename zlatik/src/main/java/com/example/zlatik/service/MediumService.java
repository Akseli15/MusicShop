package com.example.zlatik.service;

import com.example.zlatik.entity.Medium;
import com.example.zlatik.repository.MediumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediumService {
    @Autowired
    MediumRepository mediumRepository;
    @Async
    public List<Medium> getAllMediums() {
        return mediumRepository.findAll();
    }
    @Async
    public Medium getMediumByTitle(Integer title) {
        return mediumRepository.findById(title).orElse(null);
    }
    @Async
    public Medium createMedium(Medium medium) {
        return mediumRepository.save(medium);
    }
    @Async
    public void deleteMedium(Integer title) {
        mediumRepository.deleteById(title);
    }
}
