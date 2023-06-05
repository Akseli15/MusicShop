package com.example.zlatik.service;

import com.example.zlatik.entity.Genre;
import com.example.zlatik.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;
    @Async
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }
    @Async
    public Genre getById(Long id_genre) {
        return genreRepository.findById(id_genre).orElse(null);
    }
    @Async
    public void create(Genre genre) {
        genreRepository.save(genre);
    }
    @Async
    public void delete(Long id_genre) {
        genreRepository.deleteById(id_genre);
    }
    @Async
    public void update(Genre genre) {
        Genre genre1 = getById(genre.getId());
        genre1.setGenreName(genre.getGenreName());
        genreRepository.save(genre1);
    }
}

