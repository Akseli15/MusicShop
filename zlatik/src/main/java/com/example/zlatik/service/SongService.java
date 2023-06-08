package com.example.zlatik.service;

import com.example.zlatik.entity.Album;
import com.example.zlatik.entity.Genre;
import com.example.zlatik.entity.Song;
import com.example.zlatik.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongService {

    @Autowired
    SongRepository songRepository;
    @Autowired
    GenreService genreService;
    public List<Song> getAll() {
        return songRepository.findAll();
    }

    public Song getById(Long id_song) {
        return songRepository.findById(id_song).orElse(null);
    }

    public void create(Song song) {
        songRepository.save(song);
    }

    public void delete(Long id_song) {
        songRepository.deleteById(id_song);
    }

    public void update(Song song) {
        Song song1 = getById(song.getId());
        song1.setSongName(song.getSongName());
        song1.setAuthor(song.getAuthor());
        song1.setSongDuration(song.getSongDuration());
        Genre genre = genreService.getByGenreName(song.getGenre().getGenreName());
        song1.setGenre(genre);
        songRepository.save(song1);
    }
    public Song getBySongName(String songName) {
        return songRepository.findFirstBySongName(songName);
    }
}
