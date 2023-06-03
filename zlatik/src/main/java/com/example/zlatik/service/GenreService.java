package com.example.zlatik.service;

import com.example.zlatik.entity.Artist;
import com.example.zlatik.entity.Genre;
import com.example.zlatik.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {
    @Autowired
    GenreRepository genreRepository;
    @Async
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }
    @Async
    public Genre getGenreByTitle(String title) {
        return genreRepository.findById(title).orElse(null);
    }
    @Async
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }
    @Async
    public void deleteGenre(String title) {
        genreRepository.deleteById(title);
    }
    @Async
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }
}

