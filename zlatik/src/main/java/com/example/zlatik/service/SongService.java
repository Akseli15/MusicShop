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
    private SongRepository songRepository;
    @Async
    public List<Song> getAll() {
        return songRepository.findAll();
    }
    @Async
    public Song getById(Long id_song) {
        return songRepository.findById(id_song).orElse(null);
    }
    @Async
    public void create(Song song) {
        songRepository.save(song);
    }
    @Async
    public void delete(Long id_song) {
        songRepository.deleteById(id_song);
    }
    @Async
    public void update(Song song) {
        Song song1 = getById(song.getId());
        song1.setSongName(song.getSongName());
        song1.setAuthor(song.getAuthor());
        song1.setSongDuration(song.getSongDuration());
        song1.setGenre(song.getGenre());
        songRepository.save(song1);
    }
}
