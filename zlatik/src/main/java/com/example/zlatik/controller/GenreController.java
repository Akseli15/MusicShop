package com.example.zlatik.controller;

import com.example.zlatik.entity.ContainsMedium;
import com.example.zlatik.entity.Genre;
import com.example.zlatik.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    GenreService genreService;

    @Async
    @GetMapping
    public String getAllContainsMediums(Model model) {
        model.addAttribute("genre", genreService.getAllGenres());
        return "genre";
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
    @PostMapping("/delete/{id}")
    public String deleteGenre(@PathVariable("id") String title) {
        genreService.deleteGenre(title);
        return "redirect:/genres";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String editGenre(@PathVariable("id") String title, Model model) {
        Genre genre = genreService.getGenreByTitle(title);
        Map<String, Object> entityFields = createFieldsForContainsGroup(genre);
        model.addAttribute("entity", entityFields);
        return "redirect:/";
    }

    private Map<String, Object> createFieldsForContainsGroup(Genre genre) {
        Map<String, Object> entityFields = new HashMap<>();
        entityFields.put("Название жанра", genre.getName());
        return entityFields;
    }
}

