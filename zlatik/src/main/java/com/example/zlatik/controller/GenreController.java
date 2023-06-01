package com.example.zlatik.controller;

import com.example.zlatik.entity.Genre;
import com.example.zlatik.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {
    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }
    @Async
    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }
    @Async
    @GetMapping("/{title}")
    public Genre getGenreByTitle(@PathVariable("title") String title) {
        return genreService.getGenreByTitle(title);
    }
    @Async
    @PostMapping
    public Genre createGenre(@RequestBody Genre genre) {
        return genreService.createGenre(genre);
    }
    @Async
    @DeleteMapping("/{title}")
    public void deleteGenre(@PathVariable("title") String title) {
        genreService.deleteGenre(title);
    }
}

