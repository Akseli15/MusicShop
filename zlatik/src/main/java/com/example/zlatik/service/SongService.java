package com.example.zlatik.service;

import com.example.zlatik.entity.Song;
import com.example.zlatik.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongService {
    @Autowired
    SongRepository songRepository;
    @Async
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }
    @Async
    public Song getSongByTitle(String title) {
        return songRepository.findById(title).orElse(null);
    }
    @Async
    public Song createSong(Song song) {
        return songRepository.save(song);
    }
    @Async
    public void deleteSong(String title) {
        songRepository.deleteById(title);
    }
}
