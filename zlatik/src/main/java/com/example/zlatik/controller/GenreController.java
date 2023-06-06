package com.example.zlatik.controller;

import com.example.zlatik.entity.Genre;
import com.example.zlatik.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    GenreService genreService;
    @Async
    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("genres", genreService.getAll());
        return "genre";
    }
    @Async
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        Genre genre = genreService.getById(id);
        model.addAttribute("genre",genre);
        return "genre-details";
    }
    @Async
    @PostMapping("/create")
    public String create(@ModelAttribute Genre genre){
        genreService.create(genre);
        return "redirect:/genre";
    }
    @Async
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        genreService.delete(id);
        return "redirect:/genre";
    }
    @Async
    @PostMapping("/save")
    public String save(@ModelAttribute("genre") Genre genre) {
        genreService.update(genre);
        return "redirect:/genre";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String getGenre(@PathVariable("id") Long id, Model model) {
        Genre genre = genreService.getById(id);
        model.addAttribute("genre", genre);
        return "editgenre";
    }
    @Async
    @PostMapping("/edit/{id}")
    public String editGenre(@ModelAttribute Genre genre) {
        genreService.update(genre);
        return "redirect:/genre";
    }
}

