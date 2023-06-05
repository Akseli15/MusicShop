package com.example.zlatik.service;

import com.example.zlatik.entity.Join;
import com.example.zlatik.repository.JoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinService {

    @Autowired
    private JoinRepository joinRepository;
    @Async
    public List<Join> getAll() {
        return joinRepository.findAll();
    }
    @Async
    public Join getById(Long id_join) {
        return joinRepository.findById(id_join).orElse(null);
    }
    @Async
    public void create(Join join) {
        joinRepository.save(join);
    }
    @Async
    public void delete(Long id_join) {
        joinRepository.deleteById(id_join);
    }
    @Async
    public void update(Join join) {
        Join join1 = getById(join.getId());
        join1.setArtist(join.getArtist());
        join1.setBand(join.getBand());
        join1.setJoinDate(join.getJoinDate());
        join1.setLeaveDate(join.getLeaveDate());
        joinRepository.save(join1);
    }
}
