package com.example.zlatik.service;

import com.example.zlatik.entity.MusicGroup;
import com.example.zlatik.repository.MusicGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicGroupService {
    @Autowired
    MusicGroupRepository musicGroupRepository;
    @Async
    public List<MusicGroup> getAllMusicGroups() {
        return musicGroupRepository.findAll();
    }
    @Async
    public MusicGroup getMusicGroupByTitle(String title) {
        return musicGroupRepository.findById(title).orElse(null);
    }
    @Async
    public MusicGroup createMusicGroup(MusicGroup musicGroup) {
        return musicGroupRepository.save(musicGroup);
    }
    @Async
    public void deleteMusicGroup(String title) {
        musicGroupRepository.deleteById(title);
    }
}
