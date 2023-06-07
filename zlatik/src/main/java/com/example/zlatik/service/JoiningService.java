package com.example.zlatik.service;

import com.example.zlatik.entity.Joining;
import com.example.zlatik.repository.JoiningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoiningService {

    @Autowired
    private JoiningRepository joinRepository;

    public List<Joining> getAll() {
        return joinRepository.findAll();
    }

    public Joining getById(Long id_join) {
        return joinRepository.findById(id_join).orElse(null);
    }

    public void create(Joining join) {
        joinRepository.save(join);
    }

    public void delete(Long id_join) {
        joinRepository.deleteById(id_join);
    }

    public void update(Joining join) {
        Joining join1 = getById(join.getId());
        join1.setArtist(join.getArtist());
        join1.setBand(join.getBand());
        join1.setJoinDate(join.getJoinDate());
        join1.setLeaveDate(join.getLeaveDate());
        joinRepository.save(join1);
    }
}
