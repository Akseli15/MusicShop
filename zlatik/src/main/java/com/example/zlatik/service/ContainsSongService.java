package com.example.zlatik.service;

import com.example.zlatik.entity.ContainsSong;
import com.example.zlatik.repository.ContainsSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContainsSongService {

    @Autowired
    private ContainsSongRepository containsSongRepository;

    public List<ContainsSong> getAll() {
        return containsSongRepository.findAll();
    }

    public ContainsSong getById(Long id_containssong) {
        return containsSongRepository.findById(id_containssong).orElse(null);
    }

    public void create(ContainsSong containsSong) {
        containsSongRepository.save(containsSong);
    }

    public void delete(Long id_containssong) {
        containsSongRepository.deleteById(id_containssong);
    }

    public void update(ContainsSong containsSong) {
        ContainsSong containsSong1 = getById(containsSong.getId());
        containsSong1.setAlbum(containsSong.getAlbum());
        containsSong1.setSong(containsSong.getSong());
        containsSongRepository.save(containsSong1);
    }
}
