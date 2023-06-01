package com.example.zlatik.service;

import com.example.zlatik.entity.ContainsSong;
import com.example.zlatik.repository.ContainsSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContainsSongService {
    @Autowired
    ContainsSongRepository containsSongRepository;
    @Async
    public List<ContainsSong> getAllContainsSongs() {
        return containsSongRepository.findAll();
    }
    @Async
    public ContainsSong getContainsSongByTitle(Integer id) {
        return containsSongRepository.findById(id).orElse(null);
    }
    @Async
    public ContainsSong createContainsSong(ContainsSong containsSong) {
        return containsSongRepository.save(containsSong);
    }
    @Async
    public void deleteContainsSong(Integer id) {
        containsSongRepository.deleteById(id);
    }
}
