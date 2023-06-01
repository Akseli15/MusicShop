package com.example.zlatik.service;

import com.example.zlatik.entity.ContainsMedium;
import com.example.zlatik.repository.ContainsMediumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContainsMediumService {
    @Autowired
    ContainsMediumRepository containsMediumRepository;
    @Async
    public List<ContainsMedium> getAllContainsMediums() {
        return containsMediumRepository.findAll();
    }
    @Async
    public ContainsMedium getContainsMediumByTitle(Integer id) {
        return containsMediumRepository.findById(id).orElse(null);
    }
    @Async
    public ContainsMedium createContainsMedium(ContainsMedium containsMedium) {
        return containsMediumRepository.save(containsMedium);
    }
    @Async
    public void deleteContainsMedium(Integer id) {
        containsMediumRepository.deleteById(id);
    }
}
