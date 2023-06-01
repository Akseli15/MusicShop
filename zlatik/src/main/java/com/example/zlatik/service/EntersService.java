package com.example.zlatik.service;

import com.example.zlatik.entity.Enters;
import com.example.zlatik.repository.EntersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntersService {
    @Autowired
    EntersRepository entersRepository;
    @Async
    public List<Enters> getAllEnters() {
        return entersRepository.findAll();
    }
    @Async
    public Enters getEntersByTitle(Integer id) {
        return entersRepository.findById(id).orElse(null);
    }
    @Async
    public Enters createEnters(Enters enters) {
        return entersRepository.save(enters);
    }
    @Async
    public void deleteEnters(Integer id) {
        entersRepository.deleteById(id);
    }
}
